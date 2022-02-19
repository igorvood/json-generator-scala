package ru.vood.generator.json.somemodel

import ru.vood.generator.json.dsl.Predef.NameField
import ru.vood.generator.json.service.{JsonEntityMeta, MetaProperty}

case class InternalJsonMeta3(name: String) extends JsonEntityMeta[String] {

  override val entityName: String = name
  override def jsonValue(id: String, nameField:NameField): String = generate(id)
  override val fields: Set[MetaProperty[String]] = Set(
    numProp("operation_id")(numConst(1643184276285d))
  )

}
