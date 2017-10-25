package RockPaperScissors.RockPaperScissorsUI

object ExitAction extends ConsoleAction{
  override def name: String = "exit"

  override def description: String = "This command closes the application"

  override def matcher: String = "(?i)(exit|close)"

  override def action(console: Console, consoleStatus: ConsoleStatus, input: String) {
    println("Exiting application now... Bye!")
    console.exitNow()
  }
}
