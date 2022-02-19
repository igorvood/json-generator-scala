package ru.vood.generator.json.somemodel

import ru.vood.generator.json.abstraction.AbstractStringIdentyfyedEntity
import ru.vood.generator.json.dsl.Predef.PropAssoc

case class DslJsonRandomMeta(name: String) extends AbstractStringIdentyfyedEntity {
  override def entityName: String = name

  override def fields = Set(
    "str_1" asStr defaultStr,
    "num_2" asNum defaultNum,
    "bool_3" asBool defaultBool,
    "obj" asObj InternalJsonMeta3("asd"),
    "str_10" asStr defaultStr,
    "num_20" asNum defaultNum,
    "bool_30" asBool defaultBool,
    "obj_9" asObj InternalJsonMeta3("asd1"),

  )
}
