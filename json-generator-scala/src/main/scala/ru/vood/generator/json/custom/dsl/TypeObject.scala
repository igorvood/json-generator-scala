package ru.vood.generator.json.custom.dsl

object TypeObject {

  type NameField = String

  type GenerateFieldValueFunction[ID_TYPE, OUT_TYPE] = (ID_TYPE, NameField) => OUT_TYPE


}
