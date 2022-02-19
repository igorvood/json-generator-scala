package ru.vood.generator.json.service

import java.text.DecimalFormat
import scala.collection.immutable

trait DataType[ID_TYPE] {
  def jsonValue(id: ID_TYPE): String
}

case class BooleanType[ID_TYPE](private val v: Boolean) extends DataType[ID_TYPE] {
  override def jsonValue(id: ID_TYPE): String = if (v) "true" else "false"
}

case class NumberType[ID_TYPE](private val v: BigDecimal, private val printFormat: String = "########################") extends DataType[ID_TYPE] {

  private val format = new DecimalFormat(printFormat)

  override def jsonValue(id: ID_TYPE): String = format.format(v)
}

case class StringType[ID_TYPE](private val v: String) extends DataType[ID_TYPE] {
  override def jsonValue(id: ID_TYPE): String = "\"" + v + "\""
}

case class ObjectType[ID_TYPE](private val id: ID_TYPE, private val meta: JsonEntityMeta[ID_TYPE]) extends DataType[ID_TYPE] {
  override def jsonValue(id: ID_TYPE): String = meta.generate(id)
}

case class ListObjType[ID_TYPE](
                                 private val id: ID_TYPE,
                                 private val generateId: ID_TYPE => immutable.Seq[ID_TYPE],
                                 private val meta: JsonEntityMeta[ID_TYPE]) extends DataType[ID_TYPE] {
  override def jsonValue(id: ID_TYPE): String = "[" +
    generateId(id)
      .map(nextId => meta.generate(nextId))
      .mkString(",") + "]"

}

case class ListType[ID_TYPE](
                              private val id: ID_TYPE,
                              private val generateId: ID_TYPE => immutable.Seq[ID_TYPE],
                              private val genVal: ID_TYPE => DataType[ID_TYPE]) extends DataType[ID_TYPE] {
  override def jsonValue(id: ID_TYPE): String = "[" +
    generateId(id)
      .map(nextId => genVal(nextId).jsonValue(nextId))
      .mkString(",") + "]"

}

case class MapType[ID_TYPE, KEY_TYPE](
                                       private val id: ID_TYPE,
                                       private val generateKey: ID_TYPE => immutable.Seq[KEY_TYPE],
                                       private val genVal: KEY_TYPE => DataType[KEY_TYPE]) extends DataType[ID_TYPE] {
  override def jsonValue(id: ID_TYPE): String = "{" +
    generateKey(id)
      .map(nextId => "\"" + nextId + "\":" + genVal(nextId).jsonValue(nextId))
      //      .map(nextId => nextId + ":" + genVal(nextId).jsonValue())
      .mkString(",") + "}"

}

case class MapObjType[ID_TYPE, KEY_TYPE](
                                          private val id: ID_TYPE,
                                          private val generateKey: ID_TYPE => immutable.Seq[KEY_TYPE],
                                          private val meta: JsonEntityMeta[KEY_TYPE]) extends DataType[ID_TYPE] {
  override def jsonValue(id: ID_TYPE): String = "{" +
    generateKey(id)
      .map(nextId => "\"" + nextId + "\":" + meta.generate(nextId))
      //      .map(nextId => nextId + ":" + genVal(nextId).jsonValue())
      .mkString(",") + "}"

}
