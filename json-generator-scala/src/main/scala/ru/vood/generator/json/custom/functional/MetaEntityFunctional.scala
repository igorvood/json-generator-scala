package ru.vood.generator.json.custom.functional

case class MetaEntityFunctional[ID_TYPE](name: String,
                                         property: Set[MetaPropertyFunctional[ID_TYPE]]
                                        ) {

}
