package ru.vood.generator.json.custom.functional

import ru.vood.generator.json.custom.dsl.TypeObject.{GenerateFieldValueFunction, NameField}

case class MetaPropertyFunctional[ID_TYPE](
                                  nameField: NameField,
                                  function: GenerateFieldValueFunction[ID_TYPE, DataTypeFunctional[ID_TYPE]]
                                ) {

//  def apply(id: ID_TYPE): String = "\"" + nameField + "\"" + s": ${function(id, nameField).jsonValueStr(id, nameField)}"

}
