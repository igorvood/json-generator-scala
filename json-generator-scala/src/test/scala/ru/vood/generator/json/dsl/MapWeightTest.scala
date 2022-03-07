package ru.vood.generator.json.dsl

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import ru.vood.generator.json.secondVersion.JsonData

class MapWeightTest extends  AnyFlatSpec with should.Matchers {


  "mapWeightTest" should "be called" in {
    val dict = Set("val1", "val2", "val3")

    val weight = MapWeight(dict)


    weight.getValue(32)
    assert(weight.getValue(32) == "val1")
  }

}
