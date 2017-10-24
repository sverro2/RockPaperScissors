package RockPaperScissors.messages

import RockPaperScissors.rockPaperScissorsContext.model.PlayedShape

class PlayerPlayedShape(playedShape: PlayedShape) {
  def getPlayedShape: PlayedShape = playedShape
}