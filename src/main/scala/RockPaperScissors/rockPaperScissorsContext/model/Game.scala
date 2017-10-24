package RockPaperScissors.rockPaperScissorsContext.model

import RockPaperScissors.Util.PlayableShape
import RockPaperScissors.messages.Events.PlayerPlayedShape

class Game(playerOne: Player, playerTwo: Player, var turns: Turn = new Turn(1)) {

  def startNew(player1: Player, player2: Player): Unit = { }

  def playShape(playedShape: PlayerPlayedShape): Unit = {
    val player = if (playedShape.getPlayer == playerOne.getName) playerOne else playerTwo
    val shape = playedShape.getShape match {
      case PlayableShape.Paper => Paper
      case PlayableShape.Rock => Rock
      case PlayableShape.Scissors => Scissors
    }

    turns.addPlayedShape(new PlayedShape(player, shape))
  }

}
