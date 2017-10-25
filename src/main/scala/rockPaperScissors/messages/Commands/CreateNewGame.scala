package rockPaperScissors.messages.Commands

class CreateNewGame(val gameType: GameType.Value, val playerOneName: String, val playerTwoName: String, val amountOfTurns: Int) { }

object GameType extends Enumeration {
  val PlayerVsComputer, ComputerVsComputer = Value
}
