package rockPaperScissors.rockPaperScissorsUI

object AmountOfTurnsAction extends ConsoleAction{
  override def name: String = "# of turns"

  override def description: String = "Set the number of turns before the game will end (1 - 99)"

  override def matcher: String = "\\d.*"

  override def matches(input: String): Boolean =
    super.matches(input) && input.toInt > 0 && input.toInt < 100


  override def action(console: Console, consoleState: ConsoleState, input: String): Unit = console.saveAmountOfTurns(consoleState, input)
}
