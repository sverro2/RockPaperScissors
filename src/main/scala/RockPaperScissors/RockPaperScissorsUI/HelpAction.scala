package RockPaperScissors.RockPaperScissorsUI

object HelpAction extends ConsoleAction{
  override def name: String = "help"

  override def description: String = "What to do now? Get help..."

  override def matcher: String = "(help)"

  override def action: (RockPaperScissorsConsole) => Unit = console => println("helping")
}
