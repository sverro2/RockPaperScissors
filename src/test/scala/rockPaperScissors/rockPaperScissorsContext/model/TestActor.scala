package rockPaperScissors.rockPaperScissorsContext.model

import rockPaperScissors.Util.{Actor, EventBus}

class TestActor(testFunc: Any => Unit) extends Actor {
  {
    EventBus.reset()
    EventBus.connect(this)
  }

  override def receiveMessage(message: Any): Unit = testFunc(message)
}