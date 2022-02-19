package ru.vood.generator.json.service

import ru.vood.generator.json.dsl.Predef.GenerateFieldValueFunction

case class MetaProperty[ID_TYPE](
                                  name: String,
                                  function: GenerateFieldValueFunction[ID_TYPE, DataType[ID_TYPE]]
                                ) {

  def apply(id: ID_TYPE): String = "\"" + name + "\"" + s": ${function(id, name).jsonValue(id)}"

}
