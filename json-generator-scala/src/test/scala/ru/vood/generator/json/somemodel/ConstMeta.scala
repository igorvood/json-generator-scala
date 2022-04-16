package ru.vood.generator.json.somemodel

import ru.vood.generator.json.custom.abstraction.AbstractStringIdentyfyEntity
import ru.vood.generator.json.custom.dsl.Predef.PropAssoc

case class ConstMeta(name: String) extends AbstractStringIdentyfyEntity {
  override def fields = Set(
    "const_str" asConst "const_str",
    "const_bool" asConst true,
    "const_num" asConst 1234,
  )
}
