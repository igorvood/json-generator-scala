package ru.vood.generator.json.play

import play.api.libs.json.JsValue
import ru.vood.generator.json.custom.service
import ru.vood.generator.json.custom.service.{MetaProperty, StringType}
import ru.vood.generator.json.dsl.TypeObject.NameField

object PreDef {

 /* implicit final class PropAssoc(private val self: String) extends AnyVal {

    @inline def ->[ID_TYPE](fun: ( ID_TYPE) => JsValue): JsValue
    = service.MetaProperty(self, (v1: ID_TYPE, v2: NameField) => StringType(y))
  }
*/
}
