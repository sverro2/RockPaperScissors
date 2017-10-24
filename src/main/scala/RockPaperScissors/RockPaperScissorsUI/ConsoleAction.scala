package RockPaperScissors.RockPaperScissorsUI

abstract class ConsoleAction {
  def name: String
  def description: String
  def matcher: String
  def action: RockPaperScissorsConsole => Unit

  def trigger(console: RockPaperScissorsConsole, input: String): Boolean = {
    val matches = input.matches(matcher)
    if(matches) action(console)
    println("trying match")
    matches
  }
}
