package rockPaperScissors

import rockPaperScissors.rockPaperScissorsUI.RockPaperScissorsConsole
import rockPaperScissors.rockPaperScissorsContext.actor.RockPaperScissorsActor

object Main extends App{
  // Init Backend
  RockPaperScissorsActor()

  //open UI
  new RockPaperScissorsConsole().start()
}
