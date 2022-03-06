package ru.vood.configuration.helper

import com.typesafe.config.Config

abstract class ExtractConfigValues(val path: String) {

  //  private def pathArr: Array[String] = path.split(".")

  protected def extractVal[T](name: String, fExtract: (Config, String) => T)(implicit config: Config): T = {
    val pathArr = path.split("\\.")

    def ext(pathArr: Array[String], config: Config): Config = {
      if (pathArr.isEmpty) {
        config
      } else {
        ext(pathArr.tail, config.getConfig(pathArr.head))
      }
    }

    val config2 = ext(pathArr, config)
    val t = fExtract(config2, name)
    t
  }

}
