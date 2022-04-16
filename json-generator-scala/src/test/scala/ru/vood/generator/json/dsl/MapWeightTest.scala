package ru.vood.generator.json.dsl

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import ru.vood.generator.json.custom.dsl.MapWeight

class MapWeightTest extends AnyFlatSpec with should.Matchers {


  "mapWeightTest" should "be called" in {
    val dict = Set("val1", "val2", "val3")

    val weight = MapWeight(dict)

    assert(weight.getValue(0) == "val1")
    assert(weight.getValue(3332) == "val1")
    assert(weight.getValue(3333) == "val2")
    assert(weight.getValue(3334) == "val2")
    assert(weight.getValue(6665) == "val2")
    assert(weight.getValue(6666) == "val3")
    assert(weight.getValue(9999) == "val3")
    assert(weight.getValue(10000) == "val1")


    assert(weight.getValue(0) == "val1")
    assert(weight.getValue(-3332) == "val1")
    assert(weight.getValue(-3333) == "val2")
    assert(weight.getValue(-3334) == "val2")
    assert(weight.getValue(-6665) == "val2")
    assert(weight.getValue(-6666) == "val3")
    assert(weight.getValue(-9999) == "val3")
    assert(weight.getValue(-10000) == "val1")


  }

}
