package ru.vood.generator.json.dsl

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class MapWeightTest extends AnyFlatSpec with should.Matchers {


  "mapWeightTest" should "be called" in {
    val dict = Set("val1", "val2", "val3")

    val weight = MapWeight(dict)

    assert(weight.getValue(0) == "val1")
    assert(weight.getValue(32) == "val1")
    assert(weight.getValue(33) == "val2")
    assert(weight.getValue(34) == "val2")
    assert(weight.getValue(65) == "val2")
    assert(weight.getValue(66) == "val3")
    assert(weight.getValue(99) == "val3")
    assert(weight.getValue(100) == "val1")


    assert(weight.getValue(0) == "val1")
    assert(weight.getValue(-32) == "val1")
    assert(weight.getValue(-33) == "val2")
    assert(weight.getValue(-34) == "val2")
    assert(weight.getValue(-65) == "val2")
    assert(weight.getValue(-66) == "val3")
    assert(weight.getValue(-99) == "val3")
    assert(weight.getValue(-100) == "val1")


  }

}
