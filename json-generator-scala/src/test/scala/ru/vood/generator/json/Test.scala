package ru.vood.generator.json

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import ru.vood.generator.json.somemodel.DslJsonRandomMeta

import java.math.BigInteger
import java.text.DecimalFormat

class Test extends AnyFlatSpec with should.Matchers {


  "json DslJsonRandomMeta" should "be called" in {
    val asd = DslJsonRandomMeta("asd")
    val str1 = asd.jsonValue("asd")
    val str = asd.jsonValue("asd")

    assert(str == str1)
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