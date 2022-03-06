package ru.vood.generator.json.abstraction

import ru.vood.generator.json.service.JsonEntityMeta

abstract class AbstractStringIdentyfyedEntity extends JsonEntityMeta[String] {

  override def convertHashToID(i: Int): String = i.toString

}
