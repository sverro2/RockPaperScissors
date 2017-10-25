package RockPaperScissors.rockPaperScissorsContext.model

import RockPaperScissors.Util.EventBus
import RockPaperScissors.messages.Events.{TurnHadWinner, TurnWasADraw}

class PlayedShape(private val player: Player, private val shape: Shape) {

  def getWinner(playedShapeOfOpponent: PlayedShape): Option[Player] = {
    if(shape == playedShapeOfOpponent.shape)
      None
    else
      if (shape.beats(playedShapeOfOpponent.shape)) Some(player) else Some(playedShapeOfOpponent.player)
  }

  def calculateWinner(playedShapeOfOpponent: PlayedShape, silently: Boolean): Option[Player] = {
    val winningPlayer = getWinner(playedShapeOfOpponent)

    if(winningPlayer.isEmpty) {
      if(!silently) EventBus.sent(new TurnWasADraw(ConvertToPlayableShape(shape)))
    }else {
      val winner = winningPlayer.get
      val winningShape = shape.winningShape(playedShapeOfOpponent.shape)
      val losingShape = shape.losingShape(playedShapeOfOpponent.shape)
      if(!silently)
        EventBus.sent(new TurnHadWinner(winner.getName, ConvertToPlayableShape(winningShape), ConvertToPlayableShape(losingShape)))
    }

    winningPlayer
  }

  def getWinningShape(playedShapeOfOpponent: PlayedShape): Option[Shape] = {
    if(shape == playedShapeOfOpponent.shape) None
    else
      if(shape.beats(playedShapeOfOpponent.shape)) Some(shape) else Some(playedShapeOfOpponent.shape)
  }

  def getPlayer: Player = player

  override def toString: String = s"${player.getName}: $shape"

}
