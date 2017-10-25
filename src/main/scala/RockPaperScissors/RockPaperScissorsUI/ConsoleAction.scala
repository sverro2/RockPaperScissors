package RockPaperScissors.RockPaperScissorsUI

abstract class ConsoleAction {
  def name: String

  def description: String

  def matcher: String

  def matches(input: String): Boolean = input.matches(matcher)

  def action(console: Console, consoleStatus: ConsoleStatus, input: String): Unit

  def trigger(console: Console, consoleStatus: ConsoleStatus, input: String): Boolean = {
    val isMatching = matches(input)
    if(isMatching) action(console, consoleStatus, input)

    isMatching
  }
}
