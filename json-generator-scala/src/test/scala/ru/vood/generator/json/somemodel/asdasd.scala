package ru.vood.generator.json.somemodel

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import play.api.libs.json.{JsArray, JsNull, JsNumber, JsObject, JsString, JsValue, Json}
import play.api.libs.json._
class asdasd extends AnyFlatSpec with should.Matchers {


  "json DslJsonRandomMeta determenistic test" should "be called" in {


    val json: JsValue = Json.parse(
      """
  {
    "name" : "Watership Down",
    "location" : {
      "lat" : 51.235685,
      "long" : -1.309197
    },
    "residents" : [ {
      "name" : "Fiver",
      "age" : 4,
      "role" : null
    }, {
      "name" : "Bigwig",
      "age" : 6,
      "role" : "Owsla"
    } ]
  }
  """)


    val json1: JsValue = JsObject(
      Seq(
        "name"     -> JsString("Watership Down"),
        "location" -> JsObject(Seq("lat" -> JsNumber(51.235685), "long" -> JsNumber(-1.309197))),
        "residents" -> JsArray(
          IndexedSeq(
            JsObject(
              Seq(
                "name" -> JsString("Fiver"),
                "age"  -> JsNumber(4),
                "role" -> JsNull
              )
            ),
            JsObject(
              Seq(
                "name" -> JsString("Bigwig"),
                "age"  -> JsNumber(6),
                "role" -> JsString("Owsla")
              )
            )
          )
        )
      )
    )
    println(json1.toString())

  }

}


