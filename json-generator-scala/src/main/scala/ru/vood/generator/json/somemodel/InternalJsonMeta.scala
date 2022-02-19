package ru.vood.generator.json.somemodel

import ru.vood.generator.json.abstraction.AbstractStringIdentifyedEntity
import ru.vood.generator.json.service.MetaProperty

case class InternalJsonMeta(name: String) extends AbstractStringIdentifyedEntity {

  override val entityName: String = name

  override val fields: Set[MetaProperty[String]] = Set(
    strProp("type")(strConst("type_1")),
    strProp("uuid")(strConst(java.util.UUID.randomUUID().toString)),
    numProp("operation_id")(numConst(1643184276285d)),
    objProp("internal_object2")(InternalJsonMeta2("fghklj")),
  )

}
