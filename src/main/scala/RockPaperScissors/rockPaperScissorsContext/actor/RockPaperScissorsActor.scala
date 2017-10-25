package RockPaperScissors.rockPaperScissorsContext.actor

import RockPaperScissors.Util.{Actor, EventBus}
import RockPaperScissors.messages.Commands.{CreateNewGame, GameType}
import RockPaperScissors.messages.Events.PlayerPlayedShape
import RockPaperScissors.rockPaperScissorsContext.model._

object RockPaperScissorsActor extends Actor{
  def apply(): Unit = {
    EventBus.reset()
    EventBus.connect(this)
  }

  var currentGame: Option[Game] = None

  def receiveMessage(message: Any): Unit = message match {
    case message: CreateNewGame => initializeGame(message)
    case message: PlayerPlayedShape => playShape(message)
    case _ => Unit
  }

  def playShape(message: PlayerPlayedShape): Unit =
    if(currentGame.isDefined) currentGame.get.playShape(message)

  def initializeGame(message: CreateNewGame): Unit = {
    val secondPlayer = new NPC(message.playerTwoName)
    val firstPlayer =
      if (message.gameType == GameType.PlayerVsComputer) new HumanPlayer(message.playerOneName)
      else new NPC(message.playerOneName)

    val firstTurn = new Turn(message.amountOfTurns)

    val game = new Game(firstPlayer, secondPlayer, firstTurn)

    currentGame = Some(game)
    currentGame.get.startTurn()
  }


}
