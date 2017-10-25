package rockPaperScissors.rockPaperScissorsContext.model

import rockPaperScissors.messages.Commands.PlayShape
import rockPaperScissors.messages.events.PlayerPlayedShape
import org.scalatest.FunSuite

class PlayerTest extends FunSuite {
  test("Gets correct name") {
    val npc = new NPC("My Name")

    assert(npc.getName === "My Name")
  }

  test("NPC player plays shape") {
    var succeeded = false
    val playerName = "Rick"

    new TestActor(message => message match {
      case message: PlayerPlayedShape => succeeded = message.getPlayer == playerName
    })

    val npc = new NPC(playerName)
    npc.play()

    assert(succeeded === true)
  }

  test("Human player asks to play shape") {
    var succeeded = false
    val playerName = "Morty"

    new TestActor(_ match {
      case message: PlayShape => succeeded = message.getPlayerName == playerName
      case _ =>
    })

    val humanPlayer = new HumanPlayer(playerName)
    humanPlayer.play()

    assert(succeeded === true)
  }
}


