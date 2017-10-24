package RockPaperScissors.RockPaperScissorsUI

object ExitAction extends ConsoleAction{
  override def name: String = "exit"
  override def description: String = "Close the application"
  override def matcher: String = "(exit)"
  override def action: RockPaperScissorsConsole => Unit = console => {
    println("Exiting application now... Bye!")
    console.exitNow()
  }
}
