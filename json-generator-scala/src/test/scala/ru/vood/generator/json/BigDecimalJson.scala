package ru.vood.generator.json

import ru.vood.generator.json.service.{JsonEntityMeta, MetaProperty}

case class BigDecimalJson(name: String) extends JsonEntityMeta[String] {
  override def entityName: String = name

  override def fields: Set[MetaProperty[String]] = Set(
    numProp("less_zero_big_num_const")(numConst(-7690766346119321553d))
  )
}
