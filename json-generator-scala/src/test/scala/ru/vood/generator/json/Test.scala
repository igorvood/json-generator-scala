package ru.vood.generator.json

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import ru.vood.generator.json.somemodel.BigJsonMeta

import java.math.BigInteger
import java.text.DecimalFormat

class Test extends AnyFlatSpec with should.Matchers {


  "json" should "be called" in {
    val str = BigJsonMeta("asd").generate("asd")
    println(str)
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

    //    val str = BigDecimalJson("asd").generate("asd")
//
//    assert(str.contains("769076634611932"))
//    assert(str.contains("7690766346119321553"))
//    println(str)
  }



}