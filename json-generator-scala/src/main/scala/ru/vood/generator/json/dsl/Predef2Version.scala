package ru.vood.generator.json.dsl

import ru.vood.generator.json.dsl.TypeObject.{GenerateFieldValueFunction, NameField}
import ru.vood.generator.json.service._

import scala.collection.immutable
import scala.language.implicitConversions

object Predef2Version {
  implicit def convertHashToDouble(i: Int): Double = i.toDouble

  implicit def convertHashToString(i: Int): String = i.toString

  @inline def asEntity[ID_TYPE](elems: MetaProperty[ID_TYPE]*): JsonEntityMeta[ID_TYPE] =
    new JsonEntityMeta[ID_TYPE] {
      override def fields: Set[MetaProperty[ID_TYPE]] = Set(elems: _*)
    }

  @inline def asEntityProp[ID_TYPE](elems: MetaProperty[ID_TYPE]*): Set[MetaProperty[ID_TYPE]] = Set(elems: _*)

  implicit final class SetAdds[ID_TYPE](self: Set[MetaProperty[ID_TYPE]]) {

    @inline def genCount(genFun: (ID_TYPE, NameField) => immutable.Seq[ID_TYPE]): MetaProperty[ID_TYPE] = {
      val meta = new JsonEntityMeta[ID_TYPE] {
        override def fields: Set[MetaProperty[ID_TYPE]] = self
      }
      val list = ListType(genFun, { (q: ID_TYPE, w: NameField) => meta })
      val value = MetaProperty("self", { (v1: ID_TYPE, v2: NameField) => list })
      value
    }
  }

  implicit final class PropAssoc(private val self: String) extends AnyVal {

    @inline def ->[ID_TYPE](y: String): MetaProperty[ID_TYPE]
    = MetaProperty(self, (v1: ID_TYPE, v2: NameField) => StringType(y))

    @inline def ->[ID_TYPE](y: BigDecimal): MetaProperty[ID_TYPE] =
      MetaProperty(self, (v1: ID_TYPE, v2: NameField) => NumberType(y))

    @inline def ->[ID_TYPE](y: Boolean): MetaProperty[ID_TYPE] =
      MetaProperty(self, (v1: ID_TYPE, v2: NameField) => BooleanType(y))

    @inline def ->[ID_TYPE](y: DataType[ID_TYPE]): MetaProperty[ID_TYPE] =
      MetaProperty(self, (v1: ID_TYPE, v2: NameField) => y)

    @inline def asStr[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, String]): MetaProperty[ID_TYPE] =
      MetaProperty(self, { (i, w) => StringType(y(i, w)) })

    @inline def asNum[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, BigDecimal]): MetaProperty[ID_TYPE] =
      MetaProperty(self, { (i, w) => NumberType(y(i, w)) })

    @inline def asBool[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, Boolean]): MetaProperty[ID_TYPE] =
      MetaProperty(self, { (i, w) => BooleanType(y(i, w)) })

    @deprecated
    @inline def asList[ID_TYPE](generateId: (ID_TYPE, NameField) => immutable.Seq[ID_TYPE], y: JsonEntityMeta[ID_TYPE]): MetaProperty[ID_TYPE] =
      MetaProperty(self, { (v1: ID_TYPE, v2: NameField) => ListType(generateId, { (q, w) => y }) })

    @inline def asList[ID_TYPE](y: Set[MetaProperty[ID_TYPE]]): Set[MetaProperty[ID_TYPE]] = y

    @deprecated
    @inline def asList[ID_TYPE](generateId: (ID_TYPE, NameField) => immutable.Seq[ID_TYPE],
                                y: (ID_TYPE, NameField) => DataType[ID_TYPE]): MetaProperty[ID_TYPE] =
      MetaProperty(self, { (v1: ID_TYPE, v2: NameField) => ListType(generateId, y) })

    @deprecated
    @inline def asObj[ID_TYPE](y: DataType[ID_TYPE]): MetaProperty[ID_TYPE] =
      MetaProperty(self, (v1: ID_TYPE, v2: NameField) => y)

    @inline def asEntity[ID_TYPE](elems: MetaProperty[ID_TYPE]*): MetaProperty[ID_TYPE] = {
      val value = new JsonEntityMeta[ID_TYPE] {
        override def fields: Set[MetaProperty[ID_TYPE]] = Set(elems: _*)
      }
      MetaProperty(self, (v1: ID_TYPE, v2: NameField) => value)
    }


    @inline def asMap[ID_TYPE, KEY_TYPE](generateId: (ID_TYPE, NameField) => immutable.Seq[KEY_TYPE],
                                         y: (KEY_TYPE, NameField) => DataType[KEY_TYPE]): MetaProperty[ID_TYPE] =
      MetaProperty(self, { (v1: ID_TYPE, v2: NameField) => MapType(generateId, y) })
  }

}
