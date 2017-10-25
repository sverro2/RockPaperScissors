package rockPaperScissors.Util

trait Actor {
  def receiveMessage(message: Any): Unit
}
