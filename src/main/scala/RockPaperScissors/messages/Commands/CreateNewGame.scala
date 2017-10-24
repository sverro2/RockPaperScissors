package RockPaperScissors.messages

class CreateNewGame(gameType: GameType.type, playerOneName: String, playerTwoName: String) {
  def getGameType: GameType.type = gameType
  def getPlayerOneName = playerOneName
  def getPlayerTwoName = playerTwoName
}

object GameType extends Enumeration {
  val PlayerVsComputer, ComputerVsComputer = Value
}
