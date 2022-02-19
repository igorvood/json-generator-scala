package ru.vood.generator.json.dsl

import ru.vood.generator.json.service._

import scala.collection.immutable

object Predef {

  type NameField = String

  type GenerateFieldValueFunction[ID_TYPE, OUT_TYPE] = (ID_TYPE, NameField) => OUT_TYPE

  implicit final class ArrowAssoc(private val self: String) extends AnyVal {

    @inline def asObj[ID_TYPE](y: DataType[ID_TYPE]): MetaProperty[ID_TYPE] = MetaProperty(self, (v1: ID_TYPE, v2: NameField) => y)

    @inline def asStr[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, String]): MetaProperty[ID_TYPE] =
      MetaProperty(self, { (i, w) => StringType(y(i, w)) })

    @inline def asNum[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, BigDecimal]): MetaProperty[ID_TYPE] =
      MetaProperty(self, { (i, w) => NumberType(y(i, w)) })

    @inline def asBool[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, Boolean]): MetaProperty[ID_TYPE] =
      MetaProperty(self, { (i, w) => BooleanType(y(i, w)) })

    @inline def asListNew[ID_TYPE](
                                    generateId: (ID_TYPE, NameField) => immutable.Seq[ID_TYPE],
                                    y: (ID_TYPE, NameField) => DataType[ID_TYPE]): MetaProperty[ID_TYPE] =
      MetaProperty(self, { (v1: ID_TYPE, v2: NameField) => ListType(generateId, y) })

    //------------------------------
    @inline def asDataType[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, DataType[ID_TYPE]]): MetaProperty[ID_TYPE] = MetaProperty(self, y)


    //    @inline def asList[ID_TYPE](generateId: (ID_TYPE, NameField) => immutable.Seq[ID_TYPE], y: JsonEntityMeta[ID_TYPE]): MetaProperty[ID_TYPE] =
    //      MetaProperty(self, { (v1: ID_TYPE, v2: NameField) => ListObjType(generateId, y) })

    //    @inline def asSimpleList[ID_TYPE](generateId: (ID_TYPE, NameField) => immutable.Seq[ID_TYPE], y: ID_TYPE => DataType[ID_TYPE]): MetaProperty[ID_TYPE] =
    //      MetaProperty(self, { (v1: ID_TYPE, v2: NameField) => ListType(generateId, y) })

    @inline def asSimpleMap[ID_TYPE, KEY_TYPE](generateId: (ID_TYPE, NameField) => immutable.Seq[KEY_TYPE], y: KEY_TYPE => DataType[KEY_TYPE]): MetaProperty[ID_TYPE] =
      MetaProperty(self, { (v1: ID_TYPE, v2: NameField) => MapType(generateId, y) })

    @inline def asMap[ID_TYPE, KEY_TYPE](generateId: (ID_TYPE, NameField) => immutable.Seq[KEY_TYPE], y: JsonEntityMeta[KEY_TYPE]): MetaProperty[ID_TYPE] =
      MetaProperty(self, { (v1: ID_TYPE, v2: NameField) => MapObjType(generateId, y) })

  }

}
