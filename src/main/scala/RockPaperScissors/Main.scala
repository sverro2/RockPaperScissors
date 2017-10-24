package RockPaperScissors

import RockPaperScissors.RockPaperScissorsUI.RockPaperScissorsConsole
import RockPaperScissors.rockPaperScissorsContext.actor.RockPaperScissorsActor

object Main extends App{
  // Init Backend
  RockPaperScissorsActor()

  //open UI
  new RockPaperScissorsConsole().start()
}
