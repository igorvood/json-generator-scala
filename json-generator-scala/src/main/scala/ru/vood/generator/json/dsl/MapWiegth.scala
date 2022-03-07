package ru.vood.generator.json.dsl

import scala.annotation.tailrec
import scala.math.abs

case class MapWeight(m: Map[String, Int]) {

  private val sortedDict: List[(String, Int)] =
    m.toList.sortBy(q => q._1)

  private def badWeight: Map[String, Int] = m.filter(q => q._2 <= 0 || q._2 >= 100)

  require(badWeight.isEmpty, s"Weight in must be between 0 and 100 $badWeight")

  require(m.values.sum == 100, s"Sum Weight in must equals 100, current sum is ${m.values.sum}")


  def getValue(hash: Int): String = {
    @tailrec def v(sortedDict: List[(String, Int)], s: Int, persent: Int): String = {
      sortedDict match {
        case x :: xs if (s >= persent) => x._1
        case x :: xs if (s < persent) => v(xs, s + x._2, persent)
        case x :: Nil => x._1
        case Nil => throw new IllegalStateException("List must be not empty")
      }
    }
    v(sortedDict, 0, abs(hash) % 100)
  }
}

object MapWeight {

  def apply(dict: Set[String]): MapWeight = MapWeight((0 until dict.size)
    .map(i => {
      val i1 = if (i < dict.size - 1) 100 / dict.size else (100 - 100 / dict.size * (dict.size - 1))
      (dict.toList(i), i1)
    }
    ).toMap)
}
