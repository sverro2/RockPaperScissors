package rockPaperScissors.rockPaperScissorsUI

import org.scalatest.FunSuite
import rockPaperScissors.messages.Commands.{CreateNewGame, GameType}
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
    assert(playedPaper === true)
  }

  test("Play scissors") {
    var playedScissors = false

    new TestActor(_ match {
      case message: PlayerPlayedShape => playedScissors = message.playedShape == PlayableShape.Scissors
      case _ =>
    })

    new RockPaperScissorsConsole().playShape("SCissoRS")
    assert(playedScissors === true)
  }

  test("Player vs Computer") {
    val console = new RockPaperScissorsConsole()

    var playerVsComputer = console.gameTypeStringToGameType("plAyer vs COMputer")

    assert(playerVsComputer === GameType.PlayerVsComputer)
  }

  test("Computer vs Computer") {
    val console = new RockPaperScissorsConsole()

    var computerVsComputer = console.gameTypeStringToGameType("COmPUTER vs COMputer")

    assert(computerVsComputer === GameType.ComputerVsComputer)
  }

}
