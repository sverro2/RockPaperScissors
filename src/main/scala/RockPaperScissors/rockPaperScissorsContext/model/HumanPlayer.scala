package RockPaperScissors.rockPaperScissorsContext.model

import RockPaperScissors.Util.EventBus
import RockPaperScissors.messages.Commands.PlayShape

class HumanPlayer(val name: String) extends Player{
  override def play(): Unit = EventBus.sent(new PlayShape(getName))
}
