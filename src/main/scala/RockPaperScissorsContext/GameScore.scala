package RockPaperScissorsContext

class GameScore(playerOneScore: (Player, Int), playerTwoScore: (Player, Int)) {

  def getPlayerScore(player: Player) = if(player == playerOneScore._1) playerOneScore._2 else playerTwoScore._2

  def addToPlayerScore(player: Option[Player]) =
    if(player.isDefined)
      if(player.get == playerOneScore._1) addToPlayerOne()
      else addToPlayerTwo()
    else this

  def addToPlayerOne() = new GameScore(addOneToPlayer(playerOneScore), playerTwoScore)

  def addToPlayerTwo() = new GameScore(playerOneScore, addOneToPlayer(playerTwoScore))

  private def addOneToPlayer(playerScore: (Player, Int)): (Player, Int) = playerScore._1 -> (playerScore._2 + 1)

}
