package rockPaperScissors.rockPaperScissorsUI

object HelpAction extends ConsoleAction{
  override def name: String = "help"

  override def description: String = "What you are currently looking at..."

  override def matcher: String = "(?i)(help)"

  override def action(console: Console, consoleState: ConsoleState, input: String): Unit = console.askHelp(consoleState)
}
