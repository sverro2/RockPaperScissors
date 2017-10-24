package RockPaperScissors.rockPaperScissorsContext.actor

import RockPaperScissors.Util.{Actor, EventBus, PlayableShape}
import RockPaperScissors.messages.Commands.{CreateNewGame, GameType}
import RockPaperScissors.messages.Events.PlayerPlayedShape
import RockPaperScissors.rockPaperScissorsContext.model._

object RockPaperScissorsActor extends Actor{
  {
    EventBus.connect(this)
  }

  var currentGame: Option[Game] = None

  def receiveMessage(message: Any): Unit = message match {
    case message: CreateNewGame => initializeGame(message)
    case message: PlayerPlayedShape =>
    case _ => Unit
  }

  def playShape(message: PlayerPlayedShape): Unit = {

  }

  def initializeGame(message: CreateNewGame): Unit = {
    val secondPlayer = new NPC(message.getPlayerTwoName)
    val firstPlayer =
      if (message.getGameType == GameType.PlayerVsComputer) new HumanPlayer(message.getPlayerOneName)
      else new NPC(message.getPlayerOneName)

    currentGame = Some(new Game(firstPlayer, secondPlayer))
  }


}
