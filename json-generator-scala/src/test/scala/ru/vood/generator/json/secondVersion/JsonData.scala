package ru.vood.generator.json.secondVersion

import ru.vood.generator.json.abstraction.AbstractNumberIdentyfyedEntity
import ru.vood.generator.json.dsl.Predef2Version.{PropAssoc, asEntityProp}
import ru.vood.generator.json.service.JsonEntityMeta.asJson
import ru.vood.generator.json.service.MetaProperty

case class JsonData() extends AbstractNumberIdentyfyedEntity {

  override def fields: Set[MetaProperty[Double]] = asJson(
    "str_const" -> "asdsad",
    "num_const" -> 123,
    "bool_const" -> true,
    "null_const" -> NULL,
    "str_fun" asStr defaultStr,
    "num_fun" asNum defaultNum,
    "bool_fun" asBool defaultBool,
    "bool_fun_new" asBoolNew defaultBool,
    "obj_fun" asEntity(
      "str_fun" asStr defaultStr,
      "num_fun" asNum defaultNum,
    ),
    "str_list" asList(defaultListStr, genListCountDefault(1, 2)),
    "num_list" asList(defaultListNum, genListCountDefault(1, 2)),
    "bool_list" asList(defaultListBool, genListCountDefault(1, 2)),

    //    "str_list_new" asListSimple(defaultListStr, genListCountDefault(6, 8)),

    "obj_list_new" asListEntity asEntityProp(
      "str_fun" asStr defaultStr,
      "num_fun" asNum defaultNum,
    ) genCount genListCountDefault(1, 2)

  )
}
