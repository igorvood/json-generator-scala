package ru.vood.generator.json.somemodel

import ru.vood.generator.json.custom.abstraction.AbstractStringIdentyfyEntity
import ru.vood.generator.json.custom.service.MetaProperty
import ru.vood.generator.json.dsl.Predef.PropAssoc

case class DslJsonRandomMeta(name: String) extends AbstractStringIdentyfyEntity {
  override def fields: Set[MetaProperty[String]] = Set(
    "str_1" asStr defaultStr,
    "num_2" asNum defaultNum,
    "num_3" asNum defaultNumRange(1, 10),
    "bool_3" asBool defaultBool,
    "obj" asObj InternalJsonMeta3("asd"),
    "str_10" asStr defaultStr,
    "num_20" asNum defaultNum,
    "bool_30" asBool defaultBool,
    "obj_9" asObj InternalJsonMeta3("asd1"),

  )
}
