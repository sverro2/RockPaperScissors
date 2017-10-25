package RockPaperScissors.RockPaperScissorsUI

trait Console {
  def exitNow(): Unit
  def askHelp(currentStatus: ConsoleStatus): Unit
  def saveGameType(currentStatus: ConsoleStatus, input: String): Unit
  def saveAmountOfTurns(currentStatus: ConsoleStatus, input: String): Unit
}
