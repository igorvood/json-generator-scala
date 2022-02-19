package ru.vood.generator.json.service

import ru.vood.generator.json.dsl.Predef.NameField

import java.text.DecimalFormat
import scala.collection.immutable

trait DataType[ID_TYPE] {
  def jsonValue(id: ID_TYPE, nameField: NameField): String
}

case class BooleanType[ID_TYPE](private val v: Boolean) extends DataType[ID_TYPE] {
  override def jsonValue(id: ID_TYPE, nameField: NameField): String = if (v) "true" else "false"
}

case class NumberType[ID_TYPE](private val v: BigDecimal, private val printFormat: String = "########################") extends DataType[ID_TYPE] {

  private val format = new DecimalFormat(printFormat)

  override def jsonValue(id: ID_TYPE, nameField: NameField): String = format.format(v)
}

case class StringType[ID_TYPE](private val v: String) extends DataType[ID_TYPE] {
  override def jsonValue(id: ID_TYPE, nameField: NameField): String = "\"" + v + "\""
}

case class ObjectType[ID_TYPE](private val meta: JsonEntityMeta[ID_TYPE]) extends DataType[ID_TYPE] {
  override def jsonValue(id: ID_TYPE, nameField: NameField): String = meta.jsonValue(id, nameField)
}

case class ListObjType[ID_TYPE](
                                 private val generateId: (ID_TYPE, NameField) => immutable.Seq[ID_TYPE],
                                 private val meta: JsonEntityMeta[ID_TYPE]) extends DataType[ID_TYPE] {
  override def jsonValue(id: ID_TYPE, nameField: NameField): String = "[" +
    generateId(id, nameField)
      .map(nextId => meta.jsonValue(nextId, nameField))
      .mkString(",") + "]"

}

case class ListType[ID_TYPE, NEW_ID_TYPE](
                              private val generateId: (ID_TYPE, NameField) => immutable.Seq[NEW_ID_TYPE],
                              private val genVal: NEW_ID_TYPE => DataType[NEW_ID_TYPE]) extends DataType[ID_TYPE] {
  override def jsonValue(id: ID_TYPE, nameField: NameField): String = "[" +
    generateId(id, nameField)
      .map(nextId => genVal(nextId).jsonValue(nextId, nameField))
      .mkString(",") + "]"

}

case class MapType[ID_TYPE, KEY_TYPE](
                                       private val id: ID_TYPE,
                                       private val generateKey: ID_TYPE => immutable.Seq[KEY_TYPE],
                                       private val genVal: KEY_TYPE => DataType[KEY_TYPE]) extends DataType[ID_TYPE] {
  override def jsonValue(id: ID_TYPE, nameField: NameField): String = "{" +
    generateKey(id)
      .map(nextId => "\"" + nextId + "\":" + genVal(nextId).jsonValue(nextId, nameField))
      //      .map(nextId => nextId + ":" + genVal(nextId).jsonValue())
      .mkString(",") + "}"

}

case class MapObjType[ID_TYPE, KEY_TYPE](
                                          private val id: ID_TYPE,
                                          private val generateKey: ID_TYPE => immutable.Seq[KEY_TYPE],
                                          private val meta: JsonEntityMeta[KEY_TYPE]) extends DataType[ID_TYPE] {
  override def jsonValue(id: ID_TYPE, nameField: NameField): String = "{" +
    generateKey(id)
      .map(nextId => "\"" + nextId + "\":" + meta.generate(nextId))
      //      .map(nextId => nextId + ":" + genVal(nextId).jsonValue())
      .mkString(",") + "}"

}
