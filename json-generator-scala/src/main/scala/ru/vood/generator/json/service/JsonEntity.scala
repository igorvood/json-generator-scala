package ru.vood.generator.json.service

import ru.vood.generator.json.dsl.Predef.{GenerateFieldValueFunction, NameField}
import ru.vood.generator.json.service

import scala.collection.immutable
import scala.math.abs

trait JsonEntityMeta[ID_TYPE] extends DataType[ID_TYPE] {

  //  type ID = ID_TYPE

  val NULL = NullType[ID_TYPE]()

  def convertHashToID(i: Int): ID_TYPE

  def jsonValue(id: ID_TYPE): String = jsonValue(id, entityName)
  override def jsonValue(id: ID_TYPE, nameField: NameField): String = {
    validateMeta
    val res = meta.property
      .map(prop =>
        prop(id))
      .mkString(sep = ",")
    s"{$res}"
  }

  val defaultStr: GenerateFieldValueFunction[ID_TYPE, String] = { (id, nameField) => (id.hashCode + nameField.hashCode).toString }
  val defaultNum: GenerateFieldValueFunction[ID_TYPE, BigDecimal] = { (id, nameField) => id.hashCode + nameField.hashCode }

  def defaultNumRange(min: Double = Double.MinValue, max: Double = Double.MaxValue): GenerateFieldValueFunction[ID_TYPE, BigDecimal] = {
    (id, nameField) => (id.hashCode + nameField.hashCode) % (max - min) + min
  }

  val defaultBool: GenerateFieldValueFunction[ID_TYPE, Boolean] = { (id, nameField) =>
    if ((id.hashCode + nameField.hashCode) % 2 == 0) false else true
  }
  val defaultListNum: (ID_TYPE, NameField) => NumberType[ID_TYPE] = { (id, nameField) => NumberType(defaultNum(id, nameField)) }
  val defaultListStr: (ID_TYPE, NameField) => StringType[ID_TYPE] = { (id, nameField) => StringType(defaultStr(id, nameField)) }
  val defaultListBool: (ID_TYPE, NameField) => BooleanType[ID_TYPE] = { (id, nameField) => BooleanType(defaultBool(id, nameField)) }

  protected def genListCountDefault(min: Int = 1, max: Int = 3): (ID_TYPE, NameField) => immutable.Seq[ID_TYPE] = {
    require(min <= max)
    require(min >= 0)
    require(max >= 0)
    val result: (ID_TYPE, NameField) => immutable.Seq[ID_TYPE] = (id, name) => {
      val hash = abs(id.hashCode() + name.hashCode)
      (0 to (hash % (max - min) + min))
      .map(convertHashToID)
    }
    result
  }
  @inline protected def asJson[ID_TYPE](elems: MetaProperty[ID_TYPE]*): Set[MetaProperty[ID_TYPE]] = Set(elems:_*)

  def entityName: String

  def fields: Set[MetaProperty[ID_TYPE]]

  protected def meta: MetaEntity[ID_TYPE] = service.MetaEntity(entityName, fields)

  def validateMeta(): Unit = {
    if (badFields.nonEmpty)
      throw new IllegalStateException(s"meta is not valid fields is dublicate $badFields")
  }

  private def badFields = fields
    .groupBy(k => k.nameField)
    .map(q => (q._1, q._2.size))
    .filter(q => q._2 > 1)


}
