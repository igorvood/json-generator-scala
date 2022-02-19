package ru.vood.generator.json.service

import FunConst.{GenerateFieldValueFunction, NameField}
import ru.vood.generator.json.service

import scala.collection.immutable

trait JsonEntityMeta[ID_TYPE] {

  type ID = ID_TYPE

  def entityName: String

  def fields: Set[MetaProperty[ID_TYPE]]

  def generate(id: ID_TYPE): String = {
    validateMeta
    val res = meta.property
      .map(prop => {
        val prop1 = prop
        val str = prop1(id)
        str
      })
      .mkString(sep = ",")
    s"{$res}"
  }

  protected def meta: MetaEntity[ID_TYPE] = service.MetaEntity(entityName, fields)

  def validateMeta(): Unit = {
    if (badFields.nonEmpty)
      throw new IllegalStateException(s"meta is not valid fields is dublicate $badFields")
  }

  private def badFields = fields
    .groupBy(k => k.name)
    .map(q => (q._1, q._2.size))
    .filter(q => q._2 > 1)

  protected def strProp(nameField: NameField)(dataGen: GenerateFieldValueFunction[ID_TYPE, String]): MetaProperty[ID_TYPE] =
    MetaProperty(nameField, (v1: ID_TYPE, v2: NameField) => StringType(dataGen(v1, v2)))

  protected def numProp(nameField: NameField)(dataGen: GenerateFieldValueFunction[ID_TYPE, BigDecimal]): MetaProperty[ID_TYPE] =
    MetaProperty(nameField, (v1: ID_TYPE, v2: NameField) => NumberType(dataGen(v1, v2)))

  protected def boolProp(nameField: NameField)(dataGen: GenerateFieldValueFunction[ID_TYPE, Boolean]): MetaProperty[ID_TYPE] =
    MetaProperty(nameField, (v1: ID_TYPE, v2: NameField) => BooleanType(dataGen(v1, v2)))

  protected def objProp(nameField: NameField)(metaEntity: JsonEntityMeta[ID_TYPE]): MetaProperty[ID_TYPE] =
    MetaProperty(nameField, (v1: ID_TYPE, v2: NameField) => ObjectType(v1, metaEntity))

  protected def listProp(nameField: NameField, generateId: ID_TYPE => immutable.Seq[ID_TYPE] )(metaEntity: JsonEntityMeta[ID_TYPE]): MetaProperty[ID_TYPE] =
    MetaProperty(nameField, (v1: ID_TYPE, v2: NameField) => ListType(v1,generateId, metaEntity))


  protected def strConst(data: String): (ID_TYPE, NameField) => String = { (_, _) => data }

  protected def numConst(data: BigDecimal): (ID_TYPE, NameField) => BigDecimal = { (_, _) => data }

  protected def boolConst(data: Boolean): (ID_TYPE, NameField) => Boolean = { (_, _) => data }

  protected def strConstProp(nameField: NameField, data: String) =
    MetaProperty[ID_TYPE](nameField, {
      (_, _) => StringType(data)
    })

  protected def numConstProp(nameField: NameField, data: BigDecimal) =
    MetaProperty[ID_TYPE](nameField, {
      (_, _) => NumberType(data)
    })

  protected def boolConstProp(nameField: NameField, data: Boolean) =
    MetaProperty[ID_TYPE](nameField, {
      (_, _) => BooleanType(data)
    })

}
