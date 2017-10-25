package RockPaperScissors.RockPaperScissorsUI

object GameTypeAction extends ConsoleAction {
  override def name: String = "Player vs Computer / Computer vs Computer"

  override def description: String = "Choose the type of game you want to play"

  override def matcher: String = "(?i)(.*p.*c.*|.*c.*c.*)"

  override def action(console: Console, consoleState: ConsoleState, input: String): Unit = console.saveGameType(consoleState, input)
}
