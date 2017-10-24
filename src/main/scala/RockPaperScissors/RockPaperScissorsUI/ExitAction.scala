package RockPaperScissors.RockPaperScissorsUI

object ExitAction extends ConsoleAction{
  override def name: String = "exit"

  override def description: String = "Close the application"

  override def matcher: String = "(?i)(exit|close)"

  override def action(console: Console) {
    println("Exiting application now... Bye!")
    console.exitNow()
  }
}
