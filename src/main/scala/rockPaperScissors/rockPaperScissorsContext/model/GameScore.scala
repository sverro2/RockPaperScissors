package rockPaperScissors.rockPaperScissorsContext.model

class GameScore(playerOneScore: (Player, Int), playerTwoScore: (Player, Int)) {

  def getPlayerScore(player: Player): Int = if(player == playerOneScore._1) playerOneScore._2 else playerTwoScore._2

  def getScoresAreEqual: Boolean = playerOneScore._2 == playerTwoScore._2

  def getWinningPlayer: (Player, Int) = if(playerOneScore._2 > playerTwoScore._2) playerOneScore else playerTwoScore

  def getLosingPlayer: (Player, Int) = if(playerOneScore._2 > playerTwoScore._2) playerTwoScore else playerOneScore

  def addToPlayerScore(player: Option[Player]): GameScore =
    if(player.isDefined)
      if(player.get == playerOneScore._1) addToPlayerOne()
      else addToPlayerTwo()
    else this

  def addToPlayerOne() = new GameScore(addOneToPlayer(playerOneScore), playerTwoScore)

  def addToPlayerTwo() = new GameScore(playerOneScore, addOneToPlayer(playerTwoScore))

  private def addOneToPlayer(playerScore: (Player, Int)): (Player, Int) = playerScore._1 -> (playerScore._2 + 1)

}
