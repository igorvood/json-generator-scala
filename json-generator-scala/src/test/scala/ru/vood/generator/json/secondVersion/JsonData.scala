package ru.vood.generator.json.secondVersion

import ru.vood.generator.json.custom.abstraction.AbstractNumberIdentyfydEntity
import ru.vood.generator.json.custom.dsl.Predef2Version.{PropAssoc, asEntityProp}
import ru.vood.generator.json.custom.service.JsonEntityMeta.asJson
import ru.vood.generator.json.custom.service.MetaProperty

case class JsonData() extends AbstractNumberIdentyfydEntity {

  override def fields: Set[MetaProperty[Double]] = asJson(
    "str_const" -> "asdsad",
    "num_const" -> 123,
    "bool_const" -> true,
    "null_const" -> NULL,
    "str_fun" asStr defaultStr,
    "num_fun" asNum defaultNum,
    "bool_fun" asBool defaultBool,
    "obj_fun" asObj(
      "str_fun" asStr defaultStr,
      "num_fun" asNum defaultNum,
    ),
    "dict_set" fromDict Set("val1", "val2", "val3"),
    "dict_map" fromDict Map(("val1", 0.01d), ("val2", 0.01d), ("val3", 99.98d)),

//    (ID_TYPE, NameField) => StringType[ID_TYPE]

//    "str_list" asList[Double](defaultListStr, genListCountDefault(1, 2)),
//    "num_list" asList(defaultListNum, genListCountDefault(1, 2)),
//    "bool_list" asList(defaultListBool, genListCountDefault(1, 2)),

    //    "str_list_new" asListSimple(defaultListStr, genListCountDefault(6, 8)),

    "obj_list_new" asList asEntityProp(
      "str_fun" asStr defaultStr,
      "num_fun" asNum defaultNum,
    ) genCount genListCountDefault(1, 2)

  )
}
