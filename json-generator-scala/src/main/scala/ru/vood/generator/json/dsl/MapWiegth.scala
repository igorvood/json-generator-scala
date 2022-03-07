package ru.vood.generator.json.dsl

import scala.math.abs

case class MapWeight(m: Map[String, Int]) {

  require(badWeight.isEmpty, s"Weight in must be between 0 and 100 $badWeight")

  require(m.values.sum == 100, s"Sum Weight in must equals 100, current sum is ${m.values.sum}")

  private val sortedDict: List[(String, (Int, Int))] = {
    def cs(list: Seq[(String, Int)], s: Int): List[(String, (Int, Int))] = {
      list match {
        case x :: Nil => (x._1, (s, 100)) :: Nil
        case x :: xs => (x._1, (s, s + x._2)) :: cs(xs, s + x._2)
        case Nil => throw new IllegalStateException("List must be not empty")
      }
    }
    val tuples = cs(list = m.toList.sortBy(q => q._1), 0)
    tuples
  }


  private def badWeight: Map[String, Int] = m.filter(q => q._2 <= 0 || q._2 >= 100)

  def getValue(hash: Int): String = {
    val h = abs(hash) % 100
    sortedDict.filter(w => {
      val (s, (min, max)) = w
      if (h >= min && h < max) true else false
    }
    ).head._1
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
