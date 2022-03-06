package ru.vood.generator.json.secondVersion

import ru.vood.generator.json.abstraction.AbstractNumberIdentyfyedEntity
import ru.vood.generator.json.dsl.Predef2Version.{NULL, PropAssoc}
import ru.vood.generator.json.service.MetaProperty

class JsonData extends AbstractNumberIdentyfyedEntity {


  override def entityName: String = "ASdadasd"

  override def fields: Set[MetaProperty[Double]] = Set(
    "str_const" -> "asdsad",
    "num_const" -> 123,
    "bool_const" -> true,
    "null_const" -> NULL[Double],
    "str_fun" asStr  defaultStr,
    "num_fun" asNum  defaultNum,
    "bool_fun" asBool  defaultBool,
    //    "str_fun" asNum defaultStr,
    //    "num_3" asNum defaultNumRange(1,10),
    //    "bool_3" asBool defaultBool,
    //    "obj" asObj InternalJsonMeta3("asd"),
    //    "str_10" asStr defaultStr,
    //    "num_20" asNum defaultNum,
    //    "bool_30" asBool defaultBool,
    //    "obj_9" asObj InternalJsonMeta3("asd1"),

  )
}
