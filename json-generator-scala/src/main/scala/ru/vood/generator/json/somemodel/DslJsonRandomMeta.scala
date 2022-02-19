package ru.vood.generator.json.somemodel

import ru.vood.generator.json.abstraction.AbstractStringIdentyfyedEntity
import ru.vood.generator.json.dsl.Predef.ArrowAssoc

case class DslJsonRandomMeta(name: String) extends AbstractStringIdentyfyedEntity {
  override def entityName: String = name

  override def fields = Set(
    "str_1" asStr defaultStr,
    "num_2" asNum defaultNum,
    "bool_3" asBool defaultBool,
    "obj" asObj InternalJsonMeta3("asd"),
    "list_num" asListNew(genListCountDefault(1, 10), defaultListNum),
    "list_str" asListNew(genListCountDefault(1, 10), defaultListStr),
    "list_bool" asListNew(genListCountDefault(1, 10), defaultListBool),

  )
}
