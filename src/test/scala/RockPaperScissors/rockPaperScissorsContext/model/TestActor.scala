package RockPaperScissors.rockPaperScissorsContext.model

import RockPaperScissors.Util.{Actor, EventBus}

class TestActor(testFunc: Any => Unit) extends Actor {
  {
    EventBus.reset()
    EventBus.connect(this)
  }

  override def receiveMessage(message: Any): Unit = testFunc(message)
}