package ru.vood.generator.json.somemodel

import ru.vood.generator.json.dsl.Predef.ArrowAssoc
import ru.vood.generator.json.service._

case class DslJsonRandomMeta(name: String) extends JsonEntityMeta[String] {
  override def entityName: String = name

  override def fields: Set[MetaProperty[String]] = Set(
    "str_1" asStr defaultStr,
    "num_2" asNum defaultNum,
    "bool_3" asBool defaultBool,
  )
}
