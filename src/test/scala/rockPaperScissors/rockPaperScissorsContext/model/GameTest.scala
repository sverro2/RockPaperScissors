package rockPaperScissors.rockPaperScissorsContext.model

import rockPaperScissors.util.PlayableShape
import rockPaperScissors.messages.events.{PlayerPlayedShape, TurnHadWinner, TurnWasADraw}
import org.scalatest.{BeforeAndAfterEach, FunSuite}

class GameTest extends FunSuite with BeforeAndAfterEach{
  val playerOne = new NPC("Rick")
  val playerTwo = new NPC("Morty")
  var game: Game = null

  override def beforeEach {
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

  test("Sents turninfo after completed turn") {
    var turnEventSent = false
    val testActor = new TestActor(_ match {
      case _: TurnHadWinner => turnEventSent = true
      case _: TurnWasADraw => turnEventSent = true
      case _ =>
    })

    game.playShape(new PlayerPlayedShape("Morty", PlayableShape.Rock))
    game.playShape(new PlayerPlayedShape("Morty", PlayableShape.Rock))
    game.turns.calculateWinnerOfTurn()

    assert(turnEventSent === true)
  }

  test("Doesn't sent turninfo everytime after adding a shape") {
    var turnEventSent = false
    val testActor = new TestActor(_ match {
      case _: TurnHadWinner => turnEventSent = true
      case _: TurnWasADraw => turnEventSent = true
      case _ =>
    })

    game.playShape(new PlayerPlayedShape("Morty", PlayableShape.Rock))

    assert(turnEventSent === false)
  }
  //check when events have been sent score/ turn / not when not necessary
}
