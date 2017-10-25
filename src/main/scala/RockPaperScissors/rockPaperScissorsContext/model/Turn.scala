package RockPaperScissors.rockPaperScissorsContext.model

class Turn( amountOfTurnsLeft: Int,
            private val previous: Option[Turn] = None,
            playedShape1: Option[PlayedShape] = None,
            playedShape2: Option[PlayedShape] = None ) {

  private def addTurn(): Turn =
    if(isInLastTurn)
      throw new IllegalStateException("Can't add another turn while in the last turn.")
    else
      new Turn(amountOfTurnsLeft - 1, Some(this))

  def addPlayedShape(playedShape: PlayedShape): Turn =
    if (isCompleted) addTurn().addPlayedShape(playedShape)
    else if(playedShape1.isEmpty) new Turn(amountOfTurnsLeft, previous, Some(playedShape))
    else new Turn(amountOfTurnsLeft, previous, playedShape1, Some(playedShape))

  def getAmountOfTurns: Int = {
    def getAmountOfTurnsAcc(currentTurn: Turn, turnsCount: Int): Int =
      if(currentTurn.previous.isEmpty) turnsCount
      else getAmountOfTurnsAcc(currentTurn.previous.get, turnsCount + 1)

    getAmountOfTurnsAcc(this, 1)
  }

  def calculateWinnerOfTurn(silently: Boolean = false): Option[Player] = {
    if (!isCompleted) throw new IllegalStateException("Can't calculate winner as long as the turn is not completed")
    else playedShape1.get.calculateWinner(playedShape2.get, silently)
  }

  def calculateTotalScore(): GameScore = {
    if (!isCompleted) throw new IllegalStateException("Can't calculate total score as long as the turn is not completed")

    def getTotalScoreAcc(gameScore: GameScore, currentTurn: Turn): GameScore = {
      val updatedGameScore = gameScore.addToPlayerScore(currentTurn.calculateWinnerOfTurn(true))

      if(currentTurn.previous.isEmpty) updatedGameScore
      else getTotalScoreAcc(updatedGameScore, currentTurn.previous.get)
    }

    getTotalScoreAcc(new GameScore(playedShape1.get.getPlayer -> 0, playedShape2.get.getPlayer -> 0), this)
  }

  def isCompleted: Boolean = playedShape1.isDefined && playedShape2.isDefined

  def isInLastTurn: Boolean = amountOfTurnsLeft == 1

  def allTurnsCompleted: Boolean = isCompleted && isInLastTurn

  override def toString: String = {
    val children: String = previous.getOrElse("Nil").toString
    s"[${playedShape1.getOrElse()}, ${playedShape2.getOrElse()}] -> $children"
  }

}
