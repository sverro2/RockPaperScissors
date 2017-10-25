package rockPaperScissors.rockPaperScissorsUI

import org.scalatest.FunSuite
import rockPaperScissors.messages.events.PlayerPlayedShape
import rockPaperScissors.rockPaperScissorsContext.model.TestActor
import rockPaperScissors.util.PlayableShape

class RockPaperScissorsConsoleTest extends FunSuite {

  test("Play rock") {
    var playedRock = false

    new TestActor(_ match {
      case message: PlayerPlayedShape => playedRock = message.playedShape == PlayableShape.Rock
      case _ =>
    })

    new RockPaperScissorsConsole().playShape("roCK")
    assert(playedRock === true)
  }

  test("Play paper") {
    var playedPaper = false

    new TestActor(_ match {
      case message: PlayerPlayedShape => playedPaper = message.playedShape == PlayableShape.Paper
      case _ =>
    })

    new RockPaperScissorsConsole().playShape("PaPer")
  }

  test("Play scissors") {
    var playedScissors = false

    new TestActor(_ match {
      case message: PlayerPlayedShape => playedScissors = message.playedShape == PlayableShape.Scissors
      case _ =>
    })

    new RockPaperScissorsConsole().playShape("SCissoRS")
  }

}
