package RockPaperScissors.messages.Events

import RockPaperScissors.Util.PlayableShape

class PlayerPlayedShape(val playerName: String, val playedShape: PlayableShape.Value) {
  def getShape: PlayableShape.Value = playedShape
  def getPlayer = playerName
}