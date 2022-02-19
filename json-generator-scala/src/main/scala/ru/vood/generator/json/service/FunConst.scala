package ru.vood.generator.json.service

object FunConst {

  type NameField = String

  type GenerateFieldValueFunction[ID_TYPE, OUT_TYPE] = (ID_TYPE, NameField) => OUT_TYPE


}
