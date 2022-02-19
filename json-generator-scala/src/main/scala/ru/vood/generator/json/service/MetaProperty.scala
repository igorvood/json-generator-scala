package ru.vood.generator.json.service

import FunConst.GenerateFieldValueFunction

case class MetaProperty[ID_TYPE](
                                  name: String,
                                  function: GenerateFieldValueFunction[ID_TYPE, DataType]
                                ) {

  def apply(id: ID_TYPE): String = "\"" + name + "\"" + s": ${function(id, name).jsonValue()}"

}

object MetaProperty {

  def stringIdJsonField(name: String, function: GenerateFieldValueFunction[String, DataType]): MetaProperty[String] =
    metaProperty(name, function)

  def metaProperty[ID_TYPE](name: String, function: GenerateFieldValueFunction[ID_TYPE, DataType]): MetaProperty[ID_TYPE] =
    MetaProperty[ID_TYPE](name, function)

}
