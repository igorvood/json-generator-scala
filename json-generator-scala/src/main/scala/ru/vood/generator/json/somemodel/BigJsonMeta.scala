package ru.vood.generator.json.somemodel

import ru.vood.generator.json.dsl.Predef.{ArrowAssoc, NameField}
import ru.vood.generator.json.service.{JsonEntityMeta, MetaProperty, NumberType, StringType}

import java.math.MathContext

case class BigJsonMeta(name: String) extends JsonEntityMeta[String] {
  override def jsonValue(id: String, nameField:NameField): String = generate(id)
  override val entityName: String = name

  private val asd: InternalJsonMeta = InternalJsonMeta("asd")


  override val fields: Set[MetaProperty[String]] = Set(
    numProp("num_const")(numConst(0)),
    numProp("bid_num_const")(numConst(5847820665765589324d)),
    strProp("str_const")(strConst("2.0")),
    strProp("entity_id")((id, _) => id),
    numProp("less_zero_big_num_const")(numConst(BigDecimal(-7690766346119321553d, new MathContext(23)))),
    objProp("internal_object")(asd),
    strProp("uuid")(strConst(java.util.UUID.randomUUID().toString)),
    numProp("bid_num_const_2")(numConst(1643184276285d)),
    listProp("list_object", { (id, name) => (1 to ((id.hashCode+name.hashCode) % 2 + 1)).map(_.toString) }, asd),
    listProp("list_simple_object", { id => (1 to (id.hashCode % 2 + 3)).map(_.toString) }, { id => NumberType(id.hashCode) }),

    "dsl_str_1 " asDataType[String] { (v1: String, v2: NameField) => StringType("true") }

  )
  //  val dasd = "asdad " withFun[String] { (v1: String, v2: NameField) => StringType("true") }
  //  private val value = "asdad " withFun { (v1: String, v2: NameField) => "true" }


}
