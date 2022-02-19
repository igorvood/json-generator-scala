package ru.vood.generator.json.service

case class MetaEntity[ID_TYPE](name: String,
                               property: Set[MetaProperty[ID_TYPE]]
                              )
