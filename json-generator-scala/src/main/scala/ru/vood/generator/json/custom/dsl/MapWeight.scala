package ru.vood.generator.json.dsl

import scala.math.abs

case class MapWeight(m: Map[String, Double]) {

  require(badWeight.isEmpty, s"Weight in must be between 0 and 100 $badWeight")

  require(m.values.sum == 100, s"Sum Weight in must equals 100, current sum is ${m.values.sum}")

  private val precision = 100

  private val sortedDict: List[(String, (Int, Int))] = {
    def cs(list: Seq[(String, Double)], s: Long): List[(String, (Int, Int))] = {
      list match {
        case x :: Nil =>
          (x._1, (s.toInt, precision * 100)) :: Nil
        case x :: xs =>
          val tuple = (x._1, (s.toInt, (s + x._2 * precision).toInt))
          tuple :: cs(xs, (s + x._2 * precision).toLong)
        case Nil => throw new IllegalStateException("List must be not empty")
      }
    }

    cs(list = m.toList.sortBy(q => q._1), 0)
  }


  private def badWeight: Map[String, Double] = m.filter(q => q._2 <= 0 || q._2 >= 100)

  def getValue(hash: Int): String = {
    val h = abs(hash) % (precision * 100)
    val tuples = sortedDict.filter(w => {
      val (_, (min, max)) = w
      if (h >= min && h < max) true else false
    }
    )
    tuples.head._1
  }
}

object MapWeight {

  def apply(dict: Set[String]): MapWeight = {
    val map = (0 until dict.size)
      .map(i => {
        val i1 = if (i < dict.size - 1) 100 / dict.size.toDouble else 100 - 100d / dict.size * (dict.size - 1)
        (dict.toList(i), i1)
      }
      ).toMap
    MapWeight(map)
  }
}
