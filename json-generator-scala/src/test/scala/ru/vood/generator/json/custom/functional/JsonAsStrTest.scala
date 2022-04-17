package ru.vood.generator.json.custom.functional

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class JsonAsStrTest extends AnyFlatSpec with should.Matchers {


  "json DslJsonRandomMeta determenistic test" should "be called" in {

    val value1 = NullTypeFunctional[String]()
    //    value1.convert[String]("as", "asd")

  }

}
