package ru.vood.generator.json.custom.service

import ru.vood.generator.json.custom.dsl.TypeObject.NameField

import java.text.DecimalFormat
import scala.collection.immutable

trait DataType[ID_TYPE] {
  def jsonValueStr(id: ID_TYPE, nameField: NameField): String
}

case class NullType[ID_TYPE]() extends DataType[ID_TYPE] {
  override def jsonValueStr(id: ID_TYPE, nameField: NameField): String = "null"
}

case class BooleanType[ID_TYPE](private val v: Boolean) extends DataType[ID_TYPE] {
  override def jsonValueStr(id: ID_TYPE, nameField: NameField): String = if (v) "true" else "false"
}

case class NumberType[ID_TYPE](private val v: BigDecimal, private val printFormat: String = "########################") extends DataType[ID_TYPE] {

  private val format = new DecimalFormat(printFormat)

  override def jsonValueStr(id: ID_TYPE, nameField: NameField): String = format.format(v)
}

case class StringType[ID_TYPE](private val v: String) extends DataType[ID_TYPE] {
  override def jsonValueStr(id: ID_TYPE, nameField: NameField): String = "\"" + v + "\""
}

case class ObjectType[ID_TYPE](private val meta: JsonEntityMeta[ID_TYPE]) extends DataType[ID_TYPE] {
  override def jsonValueStr(id: ID_TYPE, nameField: NameField): String = meta.jsonValueStr(id, nameField)
}

case class ListType[ID_TYPE](
                              private val generateId: (ID_TYPE, NameField) => immutable.Seq[ID_TYPE],
                              private val genVal: (ID_TYPE, NameField) => DataType[ID_TYPE]) extends DataType[ID_TYPE] {
  override def jsonValueStr(id: ID_TYPE, nameField: NameField): String = "[" +
    generateId(id, nameField)
      .map(nextId => genVal(nextId, nameField).jsonValueStr(nextId, nameField))
      .mkString(",") + "]"

}

case class MapType[ID_TYPE, KEY_TYPE](
                                       private val generateKey: (ID_TYPE, NameField) => immutable.Seq[KEY_TYPE],
                                       private val genVal: (KEY_TYPE, NameField) => DataType[KEY_TYPE]) extends DataType[ID_TYPE] {
  override def jsonValueStr(id: ID_TYPE, nameField: NameField): String = "{" +
    generateKey(id, nameField)
      .map(nextId => "\"" + nextId + "\":" + genVal(nextId, nameField).jsonValueStr(nextId, nameField))
      .mkString(",") + "}"

}

@deprecated
case class MapObjType[ID_TYPE, KEY_TYPE](
                                          private val generateKey: (ID_TYPE, NameField) => immutable.Seq[KEY_TYPE],
                                          private val meta: JsonEntityMeta[KEY_TYPE]) extends DataType[ID_TYPE] {
  override def jsonValueStr(id: ID_TYPE, nameField: NameField): String = "{" +
    generateKey(id, nameField)
      .map(nextId => "\"" + nextId + "\":" + meta.jsonValueStr(nextId, nameField))
      .mkString(",") + "}"

}
