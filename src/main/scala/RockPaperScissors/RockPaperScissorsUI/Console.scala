package RockPaperScissors.RockPaperScissorsUI

trait Console {
  def exitNow(): Unit
  def askHelp(currentStatus: ConsoleState): Unit
  def saveGameType(currentStatus: ConsoleState, input: String): Unit
  def saveAmountOfTurns(currentStatus: ConsoleState, input: String): Unit
  def playShape(input: String): Unit
}
