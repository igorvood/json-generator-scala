package ru.vood.generator.json

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import ru.vood.generator.json.dsl.GenJson
import ru.vood.generator.json.service.MetaProperty.stringIdJsonField
import ru.vood.generator.json.service.{MetaEntity, NumberType, StringType}

class Test extends AnyFlatSpec with should.Matchers {


  "small json" should "be called" in {

    BigJsonMeta("asd").generate("asd")

    //    Set[MetaProperty[String, _]]

    //    "operation_id".withFun()

    val set = Set(
      stringIdJsonField("operation_id", (_, _) => StringType("880415")),
      stringIdJsonField("type", (_, _) => StringType("way4-case-2-2")),
      stringIdJsonField("customer_id", (v1: String, _) => StringType(v1)),
      stringIdJsonField("effective_date", (_, _) => StringType("1644943372")),
      stringIdJsonField("duration", (_, _) => StringType("0")),
      stringIdJsonField("uuid", (_, _) => StringType(java.util.UUID.randomUUID().toString)),
      stringIdJsonField("process_timestamp", (_, _) => NumberType(1643184276285d))
    )
    val bigJson = MetaEntity("big_json", set)

    val str = GenJson.generate("asd", bigJson)
    println(str)
    //    Set("aa", "sdf")
  }


  "sqwemall json" should "be called" in {


    Map(1 -> 3)
    val str = BigJsonMeta("asd").generate("asd")
    println(str)


    //    Set("aa", "sdf")
  }

}