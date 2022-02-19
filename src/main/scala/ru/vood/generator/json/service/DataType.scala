package ru.vood.generator.json.service

import scala.collection.immutable

sealed trait DataType {
  def jsonValue(): String
}

case class BooleanType(private val v: Boolean) extends DataType {
  override def jsonValue(): String = if (v) "true" else "false"
}

case class NumberType(private val v: BigDecimal) extends DataType {
  override def jsonValue(): String = v.toString()
}

case class StringType(private val v: String) extends DataType {
  override def jsonValue(): String = "\"" + v + "\""
}

case class ObjectType[ID_TYPE](private val id: ID_TYPE, private val meta: JsonEntityMeta[ID_TYPE]) extends DataType {
  override def jsonValue(): String = meta.generate(id)
}

case class ListType[ID_TYPE](
                              private val id: ID_TYPE,
                              private val generateId: ID_TYPE => immutable.Seq[ID_TYPE],
                              private val meta: JsonEntityMeta[ID_TYPE]) extends DataType {
  override def jsonValue(): String = "[" +
    generateId(id)
      .map(nextId => meta.generate(nextId))
      .mkString(",") + "]"


}



