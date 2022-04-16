package ru.vood.generator.json.somemodel

import ru.vood.generator.json.custom.abstraction.AbstractStringIdentyfyEntity
import ru.vood.generator.json.custom.service.MetaProperty
import ru.vood.generator.json.dsl.Predef._

case class ListObject(name: String) extends AbstractStringIdentyfyEntity {
  override def fields: Set[MetaProperty[String]] = {

    Set(
      "bool_list" asList(genListCountDefault(1, 10), { (q, qw) => InternalJsonMeta3(qw) }),
      "obj_list1" asList(genListCountDefault(2, 5), { (q, qw) => InternalJsonMeta3(qw) })
    )
  }
}
