package RockPaperScissors.Util

object EventStream {
  var listeners: List[Actor] = Nil

  def connect(actor: Actor): Unit = {
    listeners = actor :: listeners
  }

  def sent(message: Any): Unit = {
    listeners.foreach(_.receiveMessage(message))
  }
}
