package ru.vood.generator.json.somemodel

import ru.vood.generator.json.abstraction.AbstractStringIdentyfyedEntity
import ru.vood.generator.json.dsl.Predef.PropAssoc
import ru.vood.generator.json.service.StringType

case class MapMeta(name: String) extends AbstractStringIdentyfyedEntity {
  override def entityName: String = name

  override def fields = Set(
   /* "const_str" asMap(
      { (id, name) => (1 to (id.hashCode + id.hashCode) % 10).map(_.toString) },
      { (key: String, name) => StringType(name + key.hashCode.toString) }
    )*/
  )
}