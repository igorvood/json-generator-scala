package ru.vood.configuration.helper

import ru.vood.configuration.helper.Configuration.config

case class Prop(path2: String
               ) extends ExtractConfigValues(path2) {


  val str_1 = extractVal("str_1", {
    _.getString(_)
  })
  val num_2 = 0
  val bool_3 = true
}
