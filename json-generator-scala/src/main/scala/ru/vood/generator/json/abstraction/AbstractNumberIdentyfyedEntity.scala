package ru.vood.generator.json.abstraction

import ru.vood.generator.json.service.JsonEntityMeta

abstract class AbstractNumberIdentyfyedEntity extends JsonEntityMeta[Double] {

  override def convertHashToID(i: Int): Double = i.toDouble

}
