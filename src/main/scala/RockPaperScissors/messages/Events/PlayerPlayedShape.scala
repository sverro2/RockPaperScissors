package RockPaperScissors.messages.Events

import RockPaperScissors.Util.PlayableShape

class PlayerPlayedShape(playerName: String, playedShape: PlayableShape.Value) {
  def getShape: PlayableShape.Value = playedShape
  def getPlayer = playerName
}