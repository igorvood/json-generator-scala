package ru.vood.generator.json

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import ru.vood.generator.json.somemodel.MapMeta

class MapTest extends AnyFlatSpec with should.Matchers {


  "json DslJsonRandomMeta determenistic test" should "be called" in {
    val asd = MapMeta("asd")
    val str1 = asd.jsonValueStr("asd")
    val str = asd.jsonValueStr("asd")

    assert(str == str1)
    println(str1)
  }

}