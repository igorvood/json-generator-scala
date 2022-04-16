package ru.vood.generator.json.custom.dsl

import ru.vood.generator.json.custom.service
import ru.vood.generator.json.custom.service._
import ru.vood.generator.json.custom.dsl.TypeObject.{GenerateFieldValueFunction, NameField}

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

  implicit final class PropAssoc(private val self: String) extends AnyVal {

    @inline def ->[ID_TYPE](y: String): MetaProperty[ID_TYPE]
    = service.MetaProperty(self, (v1: ID_TYPE, v2: NameField) => StringType(y))

    @inline def ->[ID_TYPE](y: BigDecimal): MetaProperty[ID_TYPE] =
      service.MetaProperty(self, (v1: ID_TYPE, v2: NameField) => NumberType(y))

    @inline def ->[ID_TYPE](y: Boolean): MetaProperty[ID_TYPE] =
      service.MetaProperty(self, (v1: ID_TYPE, v2: NameField) => BooleanType(y))

    @inline def ->[ID_TYPE](y: DataType[ID_TYPE]): MetaProperty[ID_TYPE] =
      service.MetaProperty(self, (v1: ID_TYPE, v2: NameField) => y)

    @inline def asStr[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, String]): MetaProperty[ID_TYPE] =
      as[ID_TYPE, String](qw = { (i, w) => StringType(y(i, w)) })

    @inline def asNum[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, BigDecimal]): MetaProperty[ID_TYPE] =
      as[ID_TYPE, BigDecimal](qw = { (i, w) => NumberType(y(i, w)) })

    @inline def asBool[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, Boolean]): MetaProperty[ID_TYPE] =
      as[ID_TYPE, Boolean](qw = { (i, w) => BooleanType(y(i, w)) })

    @inline private def as[ID_TYPE, OUT_TYPE](qw: GenerateFieldValueFunction[ID_TYPE, DataType[ID_TYPE]]): MetaProperty[ID_TYPE] =
      service.MetaProperty(self, { (i, w) => qw(i, w) })

    @inline def asList[ID_TYPE](y: Set[MetaProperty[ID_TYPE]]): MetaEntity[ID_TYPE] = MetaEntity(self, y)

    @inline def asList[ID_TYPE](y: (ID_TYPE, NameField) => DataType[ID_TYPE])
                               (implicit generateId: (ID_TYPE, NameField) => immutable.Seq[ID_TYPE]): MetaProperty[ID_TYPE] =
      service.MetaProperty(self, { (v1: ID_TYPE, v2: NameField) => ListType(generateId, y) })

    @inline def asObj[ID_TYPE](elems: MetaProperty[ID_TYPE]*): MetaProperty[ID_TYPE] = {
      val entityMeta = new JsonEntityMeta[ID_TYPE] {
        override def fields: Set[MetaProperty[ID_TYPE]] = Set(elems: _*)
      }
      service.MetaProperty(self, (v1: ID_TYPE, v2: NameField) => entityMeta)
    }

    @inline def fromDict[ID_TYPE](dict: Set[String]): MetaProperty[ID_TYPE] = {
      val function = new GenerateFieldValueFunction[ID_TYPE, StringType[ID_TYPE]] {
        override def apply(v1: ID_TYPE, v2: NameField): StringType[ID_TYPE] =
          StringType(MapWeight(dict).getValue(v1.hashCode() + v2.hashCode))
      }
      as[ID_TYPE, String](qw = function)
    }

    @inline def fromDict[ID_TYPE](dict: Map[String, Double]): MetaProperty[ID_TYPE] = {
      val function = new GenerateFieldValueFunction[ID_TYPE, StringType[ID_TYPE]] {
        override def apply(v1: ID_TYPE, v2: NameField): StringType[ID_TYPE] =
          StringType(MapWeight(dict).getValue(v1.hashCode() + v2.hashCode))
      }
      as[ID_TYPE, String](qw = function)
    }


    @inline def asMap[ID_TYPE, KEY_TYPE](generateId: (ID_TYPE, NameField) => immutable.Seq[KEY_TYPE],
                                         y: (KEY_TYPE, NameField) => DataType[KEY_TYPE]): MetaProperty[ID_TYPE] =
      service.MetaProperty(self, { (v1: ID_TYPE, v2: NameField) => MapType(generateId, y) })
  }

}
