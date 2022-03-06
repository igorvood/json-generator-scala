package ru.vood.configuration.helper

import com.typesafe.config.{ConfigFactory, ConfigResolveOptions, ConfigResolver, ConfigValue}

object Configuration {
  implicit val config = ConfigFactory
    .load("application.json")
    .resolve(ConfigResolveOptions.defaults())
}
