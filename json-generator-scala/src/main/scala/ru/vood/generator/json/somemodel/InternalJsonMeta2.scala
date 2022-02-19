package ru.vood.generator.json.somemodel

import ru.vood.generator.json.abstraction.AbstractStringIdentifyedEntity
import ru.vood.generator.json.dsl.Predef.NameField
import ru.vood.generator.json.service.{JsonEntityMeta, MetaProperty}

case class InternalJsonMeta2(name: String) extends AbstractStringIdentifyedEntity {
  override val entityName: String = name
  override val fields: Set[MetaProperty[String]] = Set(
    strProp("uuid")(strConst(java.util.UUID.randomUUID().toString)),
    numProp("operation_id")(numConst(1643184276285d))
  )

}
