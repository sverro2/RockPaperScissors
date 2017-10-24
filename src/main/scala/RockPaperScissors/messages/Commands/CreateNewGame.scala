package RockPaperScissors.messages.Commands

class CreateNewGame(gameType: GameType.Value, playerOneName: String, playerTwoName: String, amountOfTurns: Int) {
  def getGameType: GameType.Value = gameType
  def getPlayerOneName = playerOneName
  def getPlayerTwoName = playerTwoName
  def getAmountOfTurns = amountOfTurns
}

object GameType extends Enumeration {
  val PlayerVsComputer, ComputerVsComputer = Value
}
