package ru.vood.generator.json.somemodel

import ru.vood.generator.json.abstraction.AbstractStringIdentyfyedEntity
import ru.vood.generator.json.dsl.Predef.PropAssoc
import ru.vood.generator.json.service.MetaProperty

case class InternalJsonMeta3(name: String) extends AbstractStringIdentyfyedEntity {
  override val fields: Set[MetaProperty[String]] = Set(
    "str_1" asStr defaultStr,
    "num_2" asNum defaultNum,
    "bool_3" asBool defaultBool,
  )

}
