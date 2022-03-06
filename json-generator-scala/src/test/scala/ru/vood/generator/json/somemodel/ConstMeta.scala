package ru.vood.generator.json.somemodel

import ru.vood.generator.json.abstraction.AbstractStringIdentyfyedEntity
import ru.vood.generator.json.dsl.Predef.PropAssoc

case class ConstMeta(name: String) extends AbstractStringIdentyfyedEntity {
  override def fields = Set(
    "const_str" asConst "const_str",
    "const_bool" asConst true,
    "const_num" asConst 1234,
  )
}
