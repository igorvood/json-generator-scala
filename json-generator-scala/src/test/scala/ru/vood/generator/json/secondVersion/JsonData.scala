package ru.vood.generator.json.secondVersion

import ru.vood.generator.json.abstraction.AbstractNumberIdentyfyedEntity
import ru.vood.generator.json.dsl.Predef2Version.{PropAssoc, SetAdds, asEntity, asEntityProp}
import ru.vood.generator.json.dsl.TypeObject.NameField
import ru.vood.generator.json.service.JsonEntityMeta.asJson
import ru.vood.generator.json.service.{DataType, MetaProperty}

case class JsonData() extends AbstractNumberIdentyfyedEntity {

  val sd: (Double, NameField) => DataType[Double] = { (q, qw) =>
    asEntity(
      "str_fun" asStr defaultStr,
      "num_fun" asNum defaultNum,
    )
  }

  override def fields: Set[MetaProperty[Double]] = asJson(
    /*"str_const" -> "asdsad",
    "num_const" -> 123,
    "bool_const" -> true,
    "null_const" -> NULL,
    "str_fun" asStr defaultStr,
    "num_fun" asNum defaultNum,
    "bool_fun" asBool defaultBool,
    "obj_fun" asEntity(
      "str_fun" asStr defaultStr,
      "num_fun" asNum defaultNum,
    ),
    "str_list" asList(genListCountDefault(1, 2), defaultListStr),
    "num_list" asList(genListCountDefault(1, 2), defaultListNum),
    "bool_list" asList(genListCountDefault(1, 2), defaultListBool),

    "obj_list" asList(genListCountDefault(1, 2),

      asEntity("str_fun" asStr defaultStr,
        "num_fun" asNum defaultNum,
      )
    ),*/

    "obj_list_new" asList asEntityProp(
      "str_fun" asStr defaultStr,
      "num_fun" asNum defaultNum,
    ) genCount genListCountDefault(1, 2)

  )
}
