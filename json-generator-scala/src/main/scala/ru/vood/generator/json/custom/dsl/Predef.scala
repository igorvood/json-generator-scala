package ru.vood.generator.json.custom.dsl

import ru.vood.generator.json.custom.dsl.TypeObject.{GenerateFieldValueFunction, NameField}
import ru.vood.generator.json.custom.service
import ru.vood.generator.json.custom.service._

import scala.collection.immutable
import scala.language.implicitConversions

@deprecated
object Predef {

  implicit def convertHashToDouble(i: Int): Double = i.toDouble

  implicit def convertHashToString(i: Int): String = i.toString


  implicit final class PropAssoc(private val self: String) extends AnyVal {

    @inline def asConst[ID_TYPE](y: String): MetaProperty[ID_TYPE] =
      service.MetaProperty(self, (_: ID_TYPE, _: NameField) => StringType(y))

    @inline def asConst[ID_TYPE](y: BigDecimal): MetaProperty[ID_TYPE] =
      service.MetaProperty(self, (_: ID_TYPE, _: NameField) => NumberType(y))

    @inline def asConst[ID_TYPE](y: Boolean): MetaProperty[ID_TYPE] =
      service.MetaProperty(self, (_: ID_TYPE, _: NameField) => BooleanType(y))

    @inline def asObj[ID_TYPE](y: DataType[ID_TYPE]): MetaProperty[ID_TYPE] =
      service.MetaProperty(self, (_: ID_TYPE, _: NameField) => y)

    @inline def asStr[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, String]):
    MetaProperty[ID_TYPE] =
      service.MetaProperty(self, { (i, w) => StringType(y(i, w)) })

    @inline def asNum[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, BigDecimal]): MetaProperty[ID_TYPE] =
      service.MetaProperty(self, { (i, w) => NumberType(y(i, w)) })

    @inline def asBool[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, Boolean]): MetaProperty[ID_TYPE] =
      service.MetaProperty(self, { (i, w) => BooleanType(y(i, w)) })

    @inline def asNull[ID_TYPE]: MetaProperty[ID_TYPE] =
      service.MetaProperty(self, { (_, _) => NullType() })

    @inline def asList[ID_TYPE](generateId: (ID_TYPE, NameField) => immutable.Seq[ID_TYPE],
                                y: (ID_TYPE, NameField) => DataType[ID_TYPE]): MetaProperty[ID_TYPE] =
      service.MetaProperty(self, { (_: ID_TYPE, _: NameField) => ListType(generateId, y) })

    @inline def asMap[ID_TYPE, KEY_TYPE](generateId: (ID_TYPE, NameField) => immutable.Seq[KEY_TYPE],
                                         y: (KEY_TYPE, NameField) => DataType[KEY_TYPE]): MetaProperty[ID_TYPE] =
      service.MetaProperty(self, { (_: ID_TYPE, _: NameField) => MapType(generateId, y) })
  }

}
