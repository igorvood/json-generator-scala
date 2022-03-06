package ru.vood.generator.json.service

import ru.vood.generator.json.dsl.TypeObject.{GenerateFieldValueFunction, NameField}

case class MetaProperty[ID_TYPE](
                                  nameField: NameField,
                                  function: GenerateFieldValueFunction[ID_TYPE, DataType[ID_TYPE]]
                                ) {

  def apply(id: ID_TYPE): String = "\"" + nameField + "\"" + s": ${function(id, nameField).jsonValue(id, nameField)}"

}
