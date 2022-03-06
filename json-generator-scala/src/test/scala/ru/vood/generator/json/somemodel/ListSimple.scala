package ru.vood.generator.json.somemodel

import ru.vood.generator.json.abstraction.AbstractStringIdentyfyedEntity
import ru.vood.generator.json.dsl.Predef._
import ru.vood.generator.json.service.MetaProperty

case class ListSimple(name: String) extends AbstractStringIdentyfyedEntity {
  override def fields: Set[MetaProperty[String]] = Set(
    "str_list" asList(genListCountDefault(1, 10), defaultListStr),
    "num_list1" asList(genListCountDefault(1, 10), defaultListNum),
    "bool_list" asList(genListCountDefault(1, 10), defaultListBool),
  )
}
