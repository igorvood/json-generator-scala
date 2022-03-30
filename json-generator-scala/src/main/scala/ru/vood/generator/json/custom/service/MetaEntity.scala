package ru.vood.generator.json.custom.service

import ru.vood.generator.json.dsl.TypeObject.NameField

import scala.collection.immutable

case class MetaEntity[ID_TYPE](name: String,
                               property: Set[MetaProperty[ID_TYPE]]
                              ){

  @inline def genCount(genFun: (ID_TYPE, NameField) => immutable.Seq[ID_TYPE]): MetaProperty[ID_TYPE] = {
    val meta = new JsonEntityMeta[ID_TYPE] {
      override def fields: Set[MetaProperty[ID_TYPE]] = property
    }
    val list = ListType(genFun, { (q: ID_TYPE, w: NameField) => meta })
    val value = MetaProperty(name, { (v1: ID_TYPE, v2: NameField) => list })
    value
  }
}
