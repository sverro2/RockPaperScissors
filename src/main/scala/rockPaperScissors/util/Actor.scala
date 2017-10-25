package rockPaperScissors.util

trait Actor {
  def receiveMessage(message: Any): Unit
}
