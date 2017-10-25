package rockPaperScissors.rockPaperScissorsContext.model

import rockPaperScissors.util.{EventBus, PlayableShape, RandomInstance}
import rockPaperScissors.messages.events.PlayerPlayedShape

class NPC(val name: String) extends Player {
  override def play(): Unit = {
    val randomShape = PlayableShape(RandomInstance.getNextInt(PlayableShape.maxId))
    EventBus.sent(new PlayerPlayedShape(getName, randomShape))
  }
}
