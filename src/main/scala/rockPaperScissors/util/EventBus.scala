package rockPaperScissors.util

object EventBus {
  var listeners: List[Actor] = Nil

  def connect(actor: Actor): Unit = {
    listeners = actor :: listeners
  }

  def reset(): Unit = {
    listeners = Nil
  }

  def sent(message: Any): Unit = {
    listeners.foreach(_.receiveMessage(message))
  }
}
