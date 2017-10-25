package RockPaperScissors.RockPaperScissorsUI

object AmountOfTurnsAction extends ConsoleAction{
  override def name: String = "# of turns"

  override def description: String = "Set the number of turns before the game will end"

  override def matcher: String = "\\d*"

  override def action(console: Console, consoleState: ConsoleState, input: String): Unit = console.saveAmountOfTurns(consoleState, input)
}
