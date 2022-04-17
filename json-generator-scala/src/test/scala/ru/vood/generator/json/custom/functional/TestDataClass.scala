package ru.vood.generator.json.custom.functional

class TestDataClass extends JsonEntityMetaFunction[String]{
  override val fields: Set[MetaPropertyFunctional[String]] = Set(
    MetaPropertyFunctional("str", )
  )
  override val nameEntity: String =getClass.getName
}
