package ru.vood.generator.json.dsl

import ru.vood.generator.json.service.FunConst.GenerateFieldValueFunction
import ru.vood.generator.json.service.{DataType, MetaProperty}

object Predef {

  implicit final class ArrowAssoc(private val self: String) extends AnyVal {
    def →[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, DataType]): MetaProperty[ID_TYPE] = withFun(y)

    @inline def withFun[ID_TYPE](y: GenerateFieldValueFunction[ID_TYPE, DataType]): MetaProperty[ID_TYPE] = MetaProperty(self, y)


  }

}
