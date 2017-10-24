package RockPaperScissors.Util

trait Actor {
  def receiveMessage(message: Any): Unit
}
