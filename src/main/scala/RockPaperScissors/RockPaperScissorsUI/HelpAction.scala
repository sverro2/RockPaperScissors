package RockPaperScissors.RockPaperScissorsUI

object HelpAction extends ConsoleAction{
  override def name: String = "help"

  override def description: String = "What to do now? Get help..."

  override def matcher: String = "(?i)(help)"

  override def action(console: Console): Unit = console.askHelp()
}
