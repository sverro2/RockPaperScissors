package RockPaperScissors.rockPaperScissorsContext.model

import RockPaperScissors.Util.PlayableShape
import org.scalatest.{BeforeAndAfterAll, FunSuite}

class GameTest extends FunSuite with BeforeAndAfterAll{
  val playerOne = new NPC("Rick")
  val playerTwo = new NPC("Morty")
  var game: Game = null

  override def beforeAll() {
    game = new Game(playerOne, playerTwo)
  }

  test("Successfully converting PlayableShape (Rock) to Shape (Rock)") {
    val shape = game.convertPlayableShapeToShape(PlayableShape.Rock)
    assert(shape.equals(Rock))
  }

  test("Successfully converting PlayableShape (Paper) to Shape (Paper)") {
    val shape = game.convertPlayableShapeToShape(PlayableShape.Paper)
    assert(shape.equals(Paper))
  }

  test("Successfully converting PlayableShape (Scissors) to Shape (Scissors)") {
    val shape = game.convertPlayableShapeToShape(PlayableShape.Scissors)
    assert(shape.equals(Scissors))
  }

  test("Get player one from name") {
    val player = game.convertPlayerNameToPlayer("Rick")
    assert(player == playerOne)
  }

  test("Get player two from name") {
    val player = game.convertPlayerNameToPlayer("Morty")
    assert(player == playerTwo)
  }

  test("Doesn't create game with players with same name") {
    assertThrows[IllegalArgumentException] {
      new Game(playerOne, playerOne)
    }
  }
}
