package ru.vood.generator.json

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class Test extends AnyFlatSpec with should.Matchers {


  "json" should "be called" in {
    val str = BigJsonMeta("asd").generate("asd")
    println(str)
  }

}