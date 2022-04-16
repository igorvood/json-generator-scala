package ru.vood.generator.json.somemodel

import ru.vood.generator.json.custom.abstraction.AbstractStringIdentyfyEntity
import ru.vood.generator.json.custom.service.MetaProperty
import ru.vood.generator.json.dsl.Predef.PropAssoc

case class InternalJsonMeta3(name: String) extends AbstractStringIdentyfyEntity {
  override val fields: Set[MetaProperty[String]] = Set(
    "str_1" asStr defaultStr,
    "num_2" asNum defaultNum,
    "bool_3" asBool defaultBool,
  )

}
