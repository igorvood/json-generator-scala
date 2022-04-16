package ru.vood.generator.json.somemodel

import ru.vood.generator.json.custom.abstraction.AbstractStringIdentyfyEntity
import ru.vood.generator.json.custom.service.MetaProperty
import ru.vood.generator.json.dsl.Predef._

case class ListSimple(name: String) extends AbstractStringIdentyfyEntity {
  override def fields: Set[MetaProperty[String]] = Set(
    "str_list" asList(genListCountDefault(1, 10), defaultListStr),
    "num_list1" asList(genListCountDefault(1, 10), defaultListNum),
    "bool_list" asList(genListCountDefault(1, 10), defaultListBool),
  )
}
