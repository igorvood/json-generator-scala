package ru.vood.configuration.helper

import com.typesafe.config.ConfigFactory
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

import java.util.regex.Pattern
import scala.collection.immutable.StringOps


class Test extends AnyFlatSpec with should.Matchers {


  "json DslJsonRandomMeta determenistic test" should "be called" in {

    val prop = new Prop("obj_9")
    println(prop.str_1)


//    val strings2 = Pattern.compile("\\.").split("obj_9.qwe")
//
//    val strings1 = new StringOps("obj_9 . qwe").split(".")
//    val strings = "obj_9.qwe".split("\\.").toList
//    strings

//    val strings = List("dsa", "asd")
//    strings.foreach{println(_)}


  }


}