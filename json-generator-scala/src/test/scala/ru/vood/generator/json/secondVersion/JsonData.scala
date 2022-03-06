package ru.vood.generator.json.secondVersion

import ru.vood.generator.json.abstraction.AbstractNumberIdentyfyedEntity
import ru.vood.generator.json.dsl.Predef2Version.PropAssoc
import ru.vood.generator.json.service.MetaProperty

case class JsonData() extends AbstractNumberIdentyfyedEntity {


  override def entityName: String = "ASdadasd"

  override def fields: Set[MetaProperty[Double]] = asJson(
    "str_const" -> "asdsad",
    "num_const" -> 123,
    "bool_const" -> true,
    "null_const" -> NULL,
    "str_fun" asStr defaultStr,
    "num_fun" asNum defaultNum,
    "bool_fun" asBool defaultBool,
//    "str_list" asList( genListCountDefault(1,2),defaultStr )
//    "num_list" asNum defaultNum,
//    "bool_list" asBool defaultBool,


    //  val defaultListNum: (ID_TYPE, NameField) => NumberType[ID_TYPE] = { (id, nameField) => NumberType(defaultNum(id, nameField)) }
    //  val defaultListStr: (ID_TYPE, NameField) => StringType[ID_TYPE] = { (id, nameField) => StringType(defaultStr(id, nameField)) }
    //  val defaultListBool: (ID_TYPE, NameField) => BooleanType[ID_TYPE] = { (id, nameField) => BooleanType(defaultBool(id, nameField)) }


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
