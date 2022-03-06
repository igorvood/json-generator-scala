package ru.vood.generator.json.secondVersion

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class SecondVersionDslTest extends AnyFlatSpec with should.Matchers {


  "json DslJsonRandomMeta determenistic test" should "be called" in {
    val asd = JsonData()
    val str1 = asd.jsonValue(1)

    println(str1)
  }

}