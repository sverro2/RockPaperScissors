package RockPaperScissors.rockPaperScissorsContext.model

import RockPaperScissors.Util.{EventBus, PlayableShape, RandomInstance}
import RockPaperScissors.messages.Events.PlayerPlayedShape

class NPC(val name: String) extends Player {
  override def play(): Unit = {
    val randomShape = PlayableShape(RandomInstance.getNextInt(PlayableShape.maxId))
    EventBus.sent(new PlayerPlayedShape(getName, randomShape))
  }
}
