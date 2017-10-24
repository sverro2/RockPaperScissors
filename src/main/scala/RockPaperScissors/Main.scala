package RockPaperScissors

import RockPaperScissors.rockPaperScissorsContext.model._

object Main extends App{
  println("Project test")
  val player1 = new HumanPlayer("Player1")
  val player2 = new HumanPlayer("Player2")
  val playedShape1 = new PlayedShape(player1, Rock)
  val playedShape2 = new PlayedShape(player2, Paper)

  val turns = new Turn(1, None).addPlayedShape(playedShape1).addPlayedShape(playedShape2).addPlayedShape(playedShape2).addPlayedShape(playedShape1)
  println(turns.toString)
}
