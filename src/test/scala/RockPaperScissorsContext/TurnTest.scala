package RockPaperScissorsContext

import org.scalatest.FunSuite

class TurnTest extends FunSuite {
  val player1 = new Player("Player 1")
  val player2 = new Player("Player 2")
  val playedShape1 = new PlayedShape(player1, Rock)
  val playedShape2 = new PlayedShape(player2, Paper)

  test("Turn not completed without shapes") {
    val turn = new Turn(None)
    assert(turn.isCompleted === false)
  }

  test("Turn not completed with one shape") {
    val turn = new Turn(None).addPlayedShape(playedShape1)
    assert(turn.isCompleted === false)
  }

  test("Turn completed with two shapes") {
    val turn = new Turn(None).addPlayedShape(playedShape1).addPlayedShape(playedShape2)
    assert(turn.isCompleted === true)
  }

  test("Calculate winner of turn") {
    val turn = new Turn(None).addPlayedShape(playedShape1).addPlayedShape(playedShape2)
    assert(turn.calculateWinnerOfTurn().get === player2)
  }

  test("Calculate winner of turn (opponent)") {
    val turn = new Turn(None).addPlayedShape(playedShape2).addPlayedShape(playedShape1)
    assert(turn.calculateWinnerOfTurn().get === player2)
  }

  test("Amount of turns grows when previous turn has been completed") {
    val turn = new Turn(None).addPlayedShape(playedShape2).addPlayedShape(playedShape1).addPlayedShape(playedShape1)
    assert(turn.getAmountOfTurns() === 2)
  }

  test("Throws with incomplete state: calculate winner turn") {
    val turn = new Turn(None).addPlayedShape(playedShape1)
    assertThrows[IllegalStateException] { // Result type: Assertion
      turn.calculateWinnerOfTurn()
    }
  }

  test("Throws with incomplete state: calculate total score") {
    val turn = new Turn(None).addPlayedShape(playedShape1)
    assertThrows[IllegalStateException] { // Result type: Assertion
      turn.calculateTotalScore()
    }
  }

  test("Calculate total score") {
    val turn = new Turn(None)
      .addPlayedShape(playedShape1)
      .addPlayedShape(playedShape2)
      .addPlayedShape(playedShape1)
      .addPlayedShape(playedShape2)

    val totalScore = turn.calculateTotalScore()

    assert(totalScore.getPlayerScore(player1) === 0)
    assert(totalScore.getPlayerScore(player2) === 2)
  }
}
