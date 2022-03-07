package ru.vood.generator.json.dsl

import ru.vood.generator.json.dsl.TypeObject.{GenerateFieldValueFunction, NameField}
import ru.vood.generator.json.service.{JsonEntityMeta, ListType, MetaProperty}

import scala.collection.immutable

case class ListSimple[ID_TYPE, OUT_TYPE](name: String, f: GenerateFieldValueFunction[ID_TYPE, OUT_TYPE]){

  @inline def genCount(genFun: (ID_TYPE, NameField) => immutable.Seq[ID_TYPE]): MetaProperty[ID_TYPE] = {
/*
    val meta = new JsonEntityMeta[ID_TYPE] {
      override def fields: Set[MetaProperty[ID_TYPE]] = property
    }
    val list = ListType(genFun, { (q: ID_TYPE, w: NameField) => meta })
    val value = MetaProperty(name, { (v1: ID_TYPE, v2: NameField) => list })
    value
*/


//    MetaProperty(name, { (v1: ID_TYPE, v2: NameField) => ListType(genFun, f) })
    ???
  }

}
