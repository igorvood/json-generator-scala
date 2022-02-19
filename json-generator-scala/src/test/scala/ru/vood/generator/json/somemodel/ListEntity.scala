package ru.vood.generator.json.somemodel

import ru.vood.generator.json.abstraction.AbstractStringIdentyfyedEntity
import ru.vood.generator.json.dsl.Predef.PropAssoc
import ru.vood.generator.json.service.MetaProperty

case class ListEntity(name: String) extends AbstractStringIdentyfyedEntity {
  override def entityName: String = name

  override def fields: Set[MetaProperty[String]] = Set(
    "str_list" asListNew(genListCountDefault(1, 10), defaultListStr),
    "num_list1" asListNew(genListCountDefault(1, 10), defaultListNum),
    "bool_list" asListNew(genListCountDefault(1, 10), defaultListBool),
  )
}
