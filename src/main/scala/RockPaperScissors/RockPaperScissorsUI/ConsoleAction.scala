package RockPaperScissors.RockPaperScissorsUI

abstract class ConsoleAction {
  def name: String

  def description: String

  def matcher: String

  def matches(input: String): Boolean = input.matches(matcher)

  def action(console: Console, consoleState: ConsoleState, input: String): Unit

  def trigger(console: Console, consoleState: ConsoleState, input: String): Boolean = {
    val isMatching = matches(input)
    if(isMatching) action(console, consoleState, input)

    isMatching
  }
}
