package ru.vood.generator.json.somemodel

import ru.vood.generator.json.dsl.Predef.{ArrowAssoc, NameField}
import ru.vood.generator.json.service._

case class DslJsonRandomMeta(name: String) extends JsonEntityMeta[String] {
  override def entityName: String = name

  override def jsonValue(id: String, nameField:NameField): String = generate(id)

  override def fields = Set(
    "str_1" asStr defaultStr,
    "num_2" asNum defaultNum,
    "bool_3" asBool defaultBool,
    "obj" asObj InternalJsonMeta3("asd")

  )
}
