package RockPaperScissors.rockPaperScissorsContext

import org.scalatest.FunSuite
import RockPaperScissors.rockPaperScissorsContext.model.{GameScore, HumanPlayer}

class GameScoreTest extends FunSuite {
  val playerOne = new HumanPlayer("Player 1")
  val playerTwo = new HumanPlayer("Player 2")

  test("Adds one to first player") {
    val gameScore = new GameScore(playerOne -> 0, playerTwo -> 0).addToPlayerOne()

    assert(gameScore.getPlayerScore(playerOne) === 1)
  }

  test("Adds one to second player") {
    val gameScore = new GameScore(playerOne -> 0, playerTwo -> 0).addToPlayerTwo()

    assert(gameScore.getPlayerScore(playerTwo) === 1)
  }

  test("Doesnt add one to first player") {
    val gameScore = new GameScore(playerOne -> 0, playerTwo -> 0).addToPlayerTwo()

    assert(gameScore.getPlayerScore(playerOne) === 0)
  }

  test("Adds one to both players") {
    val gameScore = new GameScore(playerOne -> 0, playerTwo -> 0).addToPlayerOne().addToPlayerTwo()

    assert(gameScore.getPlayerScore(playerOne) === 1)
    assert(gameScore.getPlayerScore(playerTwo) === 1)
  }

  test("Adds multiple to first player") {
    val gameScore = new GameScore(playerOne -> 0, playerTwo -> 0).addToPlayerOne().addToPlayerOne()

    assert(gameScore.getPlayerScore(playerOne) === 2)
  }

  test("Add to player one") {
    val gameScore = new GameScore(playerOne -> 0, playerTwo -> 0).addToPlayerScore(Some(playerOne))

    assert(gameScore.getPlayerScore(playerOne) === 1)
  }

  test("Add to player two") {
    val gameScore = new GameScore(playerOne -> 0, playerTwo -> 0).addToPlayerScore(Some(playerTwo))

    assert(gameScore.getPlayerScore(playerTwo) === 1)
  }

}
