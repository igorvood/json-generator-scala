package ru.vood.generator.json.somemodel

import ru.vood.generator.json.abstraction.AbstractStringIdentyfyedEntity
import ru.vood.generator.json.dsl.Predef._
import ru.vood.generator.json.service.MetaProperty

case class ListObject(name: String) extends AbstractStringIdentyfyedEntity {
  override def fields: Set[MetaProperty[String]] = {

    Set(
      "bool_list" asList(genListCountDefault(1, 10), { (q, qw) => InternalJsonMeta3(qw) }),
      "obj_list1" asList(genListCountDefault(2, 5), { (q, qw) => InternalJsonMeta3(qw) })
    )
  }
}
