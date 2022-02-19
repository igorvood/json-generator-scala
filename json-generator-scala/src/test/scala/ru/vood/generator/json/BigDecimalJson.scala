package ru.vood.generator.json

import ru.vood.generator.json.abstraction.AbstractStringIdentyfyedEntity
import ru.vood.generator.json.service.MetaProperty

case class BigDecimalJson(name: String) extends AbstractStringIdentyfyedEntity {
  override def entityName: String = name

  override def fields: Set[MetaProperty[String]] = Set(
    numProp("less_zero_big_num_const")(numConst(-7690766346119321553d))
  )
}
