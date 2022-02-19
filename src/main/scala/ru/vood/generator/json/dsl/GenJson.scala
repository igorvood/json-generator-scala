package ru.vood.generator.json.dsl

import ru.vood.generator.json.service.MetaEntity

@deprecated
object GenJson {

  def generate[ID_TYPE](id: ID_TYPE, meta: MetaEntity[ID_TYPE]): String = {

    val res = meta.property
      .map(prop => prop(id))
      .mkString(sep = ",")

    return s"{$res}"
  }

}
