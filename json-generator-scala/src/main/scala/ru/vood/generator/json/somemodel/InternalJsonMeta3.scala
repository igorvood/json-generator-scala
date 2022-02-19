package ru.vood.generator.json.somemodel

import ru.vood.generator.json.abstraction.AbstractStringIdentyfyedEntity
import ru.vood.generator.json.service.MetaProperty

case class InternalJsonMeta3(name: String) extends AbstractStringIdentyfyedEntity {
  override val entityName: String = name
  override val fields: Set[MetaProperty[String]] = Set(
    numProp("operation_id")(numConst(1643184276285d))
  )

}
