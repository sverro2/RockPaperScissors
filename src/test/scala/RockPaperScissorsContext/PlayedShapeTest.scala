package RockPaperScissorsContext

import org.scalatest.{FunSuite}

class PlayedShapeTest extends FunSuite {

  val player1: Player = new Player("Player 1")
  val player2: Player = new Player("Player 2")

  test("Played Rock vs Paper") {
    val playedShape1 = new PlayedShape(player1, Rock)
    val playedShape2 = new PlayedShape(player2, Paper)

    assert(playedShape1.getWinner(playedShape2).getOrElse(null) === player2)
  }

  test("Played Paper vs Rock") {
    val playedShape1 = new PlayedShape(player1, Paper)
    val playedShape2 = new PlayedShape(player2, Rock)

    assert(playedShape1.getWinner(playedShape2).getOrElse(null) === player1)
  }

  test("Played Paper vs Paper") {
    val playedShape1 = new PlayedShape(player1, Paper)
    val playedShape2 = new PlayedShape(player2, Paper)

    assert(playedShape1.getWinner(playedShape2).getOrElse(null) === null)
  }

}
