package RockPaperScissors.rockPaperScissorsContext.model

import RockPaperScissors.Util.PlayableShape
import RockPaperScissors.messages.Events.PlayerPlayedShape

class Game(playerOne: Player, playerTwo: Player, var turns: Turn = new Turn(1)) {
  require(playerOne.getName != playerTwo.getName)

  def playShape(playedShape: PlayerPlayedShape): Unit = {
    val player = convertPlayerNameToPlayer(playedShape.getPlayer)
    val shape = convertPlayableShapeToShape(playedShape.getShape)

    turns = turns.addPlayedShape(new PlayedShape(player, shape))
  }

  def convertPlayableShapeToShape(playerPlayedShape: PlayableShape.Value): Shape = {
    playerPlayedShape match {
      case PlayableShape.Paper => Paper
      case PlayableShape.Rock => Rock
      case PlayableShape.Scissors => Scissors
    }
  }

  def convertPlayerNameToPlayer(playerName: String): Player =
    if (playerName == playerOne.getName) playerOne else playerTwo

  def startTurn(): Unit = {
    playerOne.play()
    playerTwo.play()
  }

}
