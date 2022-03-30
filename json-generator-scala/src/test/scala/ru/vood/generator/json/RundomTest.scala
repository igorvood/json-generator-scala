package ru.vood.generator.json

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import ru.vood.generator.json.somemodel.DslJsonRandomMeta

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class RundomTest extends AnyFlatSpec with should.Matchers {

  "high load test" should "be called" in {

    val timeStart = LocalDateTime.now()

    val asd = DslJsonRandomMeta("asd")
    val jsons = (1 to 100000)
      .map(_.toString)
      .map(asd.jsonValue)
      .groupBy(_.hashCode)

    val intToInt = jsons
      .filter((v1: (Int, Seq[String])) => {
        val seq = v1._2
        seq
          .map(q => !seq.exists(w => w == q))
          .isEmpty
      })
    assert(intToInt.isEmpty)
    val timeEnd = LocalDateTime.now()
    val d = ChronoUnit.NANOS.between(timeStart, timeEnd) / 1000000000d
    println(d + " sec")
    assert(d <= 4)

  }

}