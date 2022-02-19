package ru.vood.generator.json

import ru.vood.generator.json.dsl.Predef.ArrowAssoc
import ru.vood.generator.json.service.FunConst.NameField
import ru.vood.generator.json.service.{JsonEntityMeta, MetaProperty, StringType}

import scala.collection.immutable

case class BigJsonMeta(name: String) extends JsonEntityMeta[String] {

  override val entityName: String = name

  private val asd: InternalJsonMeta = InternalJsonMeta("asd")


  override val fields: Set[MetaProperty[String]] = Set(
    numProp("num_const")(numConst(0)),
    numProp("bid_num_const")(numConst(5847820665765589324d)),
    strProp("str_const")(strConst("2.0")),
    strProp("entity_id")((id, _) => id),
    numProp("less_zero_big_num_const")(numConst(-7690766346119321553d)),
    objProp("internal_object")(asd),
    strProp("uuid")(strConst(java.util.UUID.randomUUID().toString)),
    numProp("bid_num_const_2")(numConst(1643184276285d)),
    listProp("list_object", { id => (1 to ("asdasd".hashCode % 2 + 2)).map(_.toString) })(asd)
  )
  val dasd = "asdad " withFun[String] {

    val strings: immutable.Seq[NameField] = (1 to ("asdasd".hashCode % 2 + 1)).map(_.toString)

    (v1: ID, v2: NameField) => StringType("true")
  }

}
