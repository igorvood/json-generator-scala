package ru.vood.generator.json.abstraction

import ru.vood.generator.json.dsl.Predef.NameField
import ru.vood.generator.json.service.JsonEntityMeta

abstract class AbstractStringIdentyfyedEntity extends JsonEntityMeta[String] {

  override def convertHashToID(i: Int): String = i.toString

  override def jsonValue(id: String, nameField: NameField): String = {
    validateMeta
    val res = meta.property
      .map(prop => {
        val prop1 = prop
        val str = prop1(id)
        str
      })
      .mkString(sep = ",")
    s"{$res}"
  }

}