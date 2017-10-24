package RockPaperScissors.messages.Commands

class CreateNewGame(gameType: GameType.Value, playerOneName: String, playerTwoName: String) {
  def getGameType: GameType.Value = gameType
  def getPlayerOneName = playerOneName
  def getPlayerTwoName = playerTwoName
}

object GameType extends Enumeration {
  val PlayerVsComputer, ComputerVsComputer = Value
}
