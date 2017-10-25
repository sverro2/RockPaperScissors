package rockPaperScissors.rockPaperScissorsContext.model

import rockPaperScissors.util.EventBus
import rockPaperScissors.messages.Commands.PlayShape

class HumanPlayer(val name: String) extends Player{
  override def play(): Unit = EventBus.sent(new PlayShape(getName))
}
