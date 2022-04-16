package ru.vood.generator.json.custom.functional

import ru.vood.generator.json.custom.dsl.TypeObject.NameField

import scala.language.implicitConversions

trait DataTypeFunctional[ID_TYPE]

case class EmptyTypeFunctional[ID_TYPE]() extends DataTypeFunctional[ID_TYPE]

case class NullTypeFunctional[ID_TYPE]() extends DataTypeFunctional[ID_TYPE]

case class BooleanType[ID_TYPE](v: (ID_TYPE, NameField) => Boolean) extends DataTypeFunctional[ID_TYPE]

case class NumberType[ID_TYPE](v: (ID_TYPE, NameField) => BigDecimal) extends DataTypeFunctional[ID_TYPE]

case class StringType[ID_TYPE](v: (ID_TYPE, NameField) => String) extends DataTypeFunctional[ID_TYPE]

case class ListType[ID_TYPE](generateId: (ID_TYPE, NameField) => Seq[ID_TYPE],
                             genVal: (ID_TYPE, NameField) => DataTypeFunctional[ID_TYPE]) extends DataTypeFunctional[ID_TYPE]

case class ObjectType[ID_TYPE](v: (ID_TYPE, NameField) => DataTypeFunctional[ID_TYPE]) extends DataTypeFunctional[ID_TYPE]
