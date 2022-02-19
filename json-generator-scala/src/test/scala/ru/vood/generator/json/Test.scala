package ru.vood.generator.json

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import ru.vood.generator.json.somemodel.{ConstMeta, DslJsonRandomMeta, ListObject, ListSimple}

import java.math.BigInteger
import java.text.DecimalFormat

class Test extends AnyFlatSpec with should.Matchers {


  "json DslJsonRandomMeta determenistic test" should "be called" in {
    val asd = DslJsonRandomMeta("asd")
    val str1 = asd.jsonValue("asd")
    val str = asd.jsonValue("asd")

    assert(str == str1)
    println(str1)
  }

  "json DslJsonRandomMeta rundom test" should "be called" in {
    val key = "asd"
    val asd = DslJsonRandomMeta("asd")

    val str1 = asd.jsonValue(key)
    val str = asd.jsonValue(key+1)

    assert(str != str1)
    println(str1)
  }

  "json ListEntity rundom test" should "be called" in {
    val key = "asd"
    val asd = ListSimple(key)

    val str1 = asd.jsonValue(key)
    val str = asd.jsonValue(key)

    assert(str == str1)
    println(str1)
  }

  "json ListObject rundom test" should "be called" in {
    val key = "asd"
    val asd = ListObject(key)

    val str1 = asd.jsonValue(key)
    val str = asd.jsonValue(key)

    assert(str == str1)
    println(str1)
  }


  "json DslJsonRandomMeta random by name test" should "be called" in {
    val key = "asd"
    val asd = DslJsonRandomMeta(key)
    val asd1 = DslJsonRandomMeta(key+"1")

    val str1 = asd.jsonValue(key)
    val str = asd1.jsonValue(key)

    assert(str != str1)
    println(str1)
  }

  "json const" should "be called" in {
    val asd = ConstMeta("asd")
    val str1 = asd.jsonValue("asd")
    val str = asd.jsonValue("asd2")


    assert(str == str1)
    assert(str == "{\"const_str\": \"const_str\",\"const_bool\": true,\"const_num\": 1234}")

    println(str1)
  }

  "json BigDecimalJson" should "be called" in {

    val format = new DecimalFormat("########################")

    val v = BigDecimal("-7690766346119321553")
    println(format.format(v))


    val v2 = BigDecimal(-7690766346119325d)

    println(format.format(v2))

    val decimal = BigDecimal(7690766346119321553d).max(v)

    println(format.format(decimal))

    val decimal1 = new BigInteger("-7690766346119321553")

    println(format.format(decimal1))

  }


}