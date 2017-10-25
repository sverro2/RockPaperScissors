package RockPaperScissors.RockPaperScissorsUI

object PlayShapeAction extends ConsoleAction{
  override def name: String = "rock/paper/scissors"

  override def description: String = "The shape you want to play"

  override def matcher: String = "(?i)(.*r.*|.*p.*p.*|.*s.*)"

  override def action(console: Console, consoleState: ConsoleState, input: String): Unit = console.playShape(input)
}
