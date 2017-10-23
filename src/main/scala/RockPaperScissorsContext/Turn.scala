package RockPaperScissorsContext

class Turn(private val previous: Option[Turn], playedShape1: Option[PlayedShape] = None, playedShape2: Option[PlayedShape] = None) {

  private def addTurn(): Turn = new Turn(Some(this))

  def getPrevious(amountOfTurnsAgo: Int): Option[Turn] =
    if(amountOfTurnsAgo > 0)
      if(previous.isDefined) previous.get.getPrevious(amountOfTurnsAgo - 1) else previous
    else
      Some(this)

  def isCompleted = playedShape1.isDefined && playedShape2.isDefined

  def addPlayedShape(playedShape: PlayedShape): Turn =
    if (isCompleted) addTurn.addPlayedShape(playedShape)
    else if(playedShape1.isEmpty) new Turn(previous, Some(playedShape))
    else new Turn(previous, playedShape1, Some(playedShape))

  def getAmountOfTurns(): Int = {
    def getAmountOfTurnsAcc(currentTurn: Turn, turnsCount: Int): Int =
      if(currentTurn.previous.isEmpty) turnsCount
      else getAmountOfTurnsAcc(currentTurn.previous.get, turnsCount + 1)

    getAmountOfTurnsAcc(this, 1)
  }

  def calculateWinnerOfTurn(): Option[Player] = {
    if (!isCompleted) throw new IllegalStateException("Can't calculate winner as long as the turn is not completed")
    else playedShape1.get.getWinner(playedShape2.get)
  }

  def calculateTotalScore(): GameScore = {
    if (!isCompleted) throw new IllegalStateException("Can't calculate total score as long as the turn is not completed")

    def getTotalScoreAcc(gameScore: GameScore, currentTurn: Turn): GameScore = {
      val updatedGameScore = gameScore.addToPlayerScore(currentTurn.calculateWinnerOfTurn())

      if(currentTurn.previous == None) updatedGameScore
      else getTotalScoreAcc(updatedGameScore, currentTurn.previous.get)
    }

    getTotalScoreAcc(new GameScore(playedShape1.get.getPlayer -> 0, playedShape2.get.getPlayer -> 0), this)
  }

  override def toString: String = {
    val children: String = previous.getOrElse("Nil").toString
    s"[${playedShape1.getOrElse()}, ${playedShape2.getOrElse()}] -> $children"
  }

}
