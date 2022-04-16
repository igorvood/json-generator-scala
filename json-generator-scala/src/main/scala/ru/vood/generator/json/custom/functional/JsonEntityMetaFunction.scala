package ru.vood.generator.json.custom.functional

trait JsonEntityMetaFunction[ID_TYPE] extends DataTypeFunctional[ID_TYPE] {

  val fields: Set[MetaPropertyFunctional[ID_TYPE]]

  val nameEntity: String

  protected val meta: MetaEntityFunctional[ID_TYPE] = MetaEntityFunctional(nameEntity, fields)

  def createData[OUT_TYPE](id: ID_TYPE)(implicit convert: ID_TYPE => OUT_TYPE): OUT_TYPE = convert(id)

}
