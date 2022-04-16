package ru.vood.generator.json.somemodel

import ru.vood.generator.json.custom.abstraction.AbstractStringIdentyfyEntity

case class MapMeta(name: String) extends AbstractStringIdentyfyEntity {
  override def fields = Set(
    /* "const_str" asMap(
       { (id, name) => (1 to (id.hashCode + id.hashCode) % 10).map(_.toString) },
       { (key: String, name) => StringType(name + key.hashCode.toString) }
     )*/
  )
}
