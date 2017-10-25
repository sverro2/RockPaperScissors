package rockPaperScissors.messages.events

import rockPaperScissors.util.PlayableShape

class PlayerPlayedShape(val playerName: String, val playedShape: PlayableShape.Value) {
  def getShape: PlayableShape.Value = playedShape
  def getPlayer = playerName
}