package ru.vood.generator.json.somemodel

import ru.vood.generator.json.dsl.Predef.ArrowAssoc
import ru.vood.generator.json.service.FunConst.NameField
import ru.vood.generator.json.service._

case class DslJsonMeta(name: String) extends JsonEntityMeta[String] {
  override def entityName: String = name

  override def fields: Set[MetaProperty[String]] = Set(
    "str_d_1" asDataType { (_: String, _: NameField) => StringType("true") },
    "num_d_1" asDataType { (_: String, _: NameField) => NumberType(6) },
    "bool_d_1" asDataType { (_: String, _: NameField) => BooleanType(true) },
    "str_2" asStr { (_: String, _: NameField) => "true" },
    "num_2" asNum { (_: String, _: NameField) => 456d },
    "bool_3" asBool { (_: String, _: NameField) => true },
    "obj_1" asObj InternalJsonMeta2("asd"),
    "list_obj_1" asList( { id => (1 to (id.hashCode % 2 + 2)).map(_.toString) }, InternalJsonMeta2("asd")),
    "simple_list__1" asSimpleList( { id => (1 to (id.hashCode % 2 + 2)).map(_.toString) }, { id => NumberType(id.hashCode) })
  )
}
