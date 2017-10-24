package rockPaperScissorsContext.actor

import messages.{CreateNewGame, GameType}
import rockPaperScissorsContext.model.{Game, HumanPlayer, NPC}

object RockPaperScissorsActor {
  var currentGame: Option[Game] = None

  def sentMessage(message: Any) = message match {
    case message: CreateNewGame => val player =
      if (message.getGameType == GameType.PlayerVsComputer)
        currentGame = Some(new Game(new HumanPlayer(message.getPlayerOneName), new NPC(message.getPlayerTwoName)))
    case _ => throw new IllegalArgumentException("Message not recognized")
  }


}
