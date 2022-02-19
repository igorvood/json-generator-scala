package ru.vood.generator.json.service

import java.text.DecimalFormat
import scala.collection.immutable

trait DataType {
  def jsonValue(): String
}

case class BooleanType(private val v: Boolean) extends DataType {
  override def jsonValue(): String = if (v) "true" else "false"
}

case class NumberType(private val v: BigDecimal, private val printFormat: String = "########################") extends DataType {

  private val format = new DecimalFormat(printFormat)

  override def jsonValue(): String = format.format(v)
}

case class StringType(private val v: String) extends DataType {
  override def jsonValue(): String = "\"" + v + "\""
}

case class ObjectType[ID_TYPE](private val id: ID_TYPE, private val meta: JsonEntityMeta[ID_TYPE]) extends DataType {
  override def jsonValue(): String = meta.generate(id)
}

case class ListObjType[ID_TYPE](
                                 private val id: ID_TYPE,
                                 private val generateId: ID_TYPE => immutable.Seq[ID_TYPE],
                                 private val meta: JsonEntityMeta[ID_TYPE]) extends DataType {
  override def jsonValue(): String = "[" +
    generateId(id)
      .map(nextId => meta.generate(nextId))
      .mkString(",") + "]"

}

case class ListType[ID_TYPE](
                              private val id: ID_TYPE,
                              private val generateId: ID_TYPE => immutable.Seq[ID_TYPE],
                              private val genVal: ID_TYPE => DataType) extends DataType {
  override def jsonValue(): String = "[" +
    generateId(id)
      .map(nextId => genVal(nextId).jsonValue())
      .mkString(",") + "]"

}

