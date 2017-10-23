package RockPaperScissorsContext

class PlayedShape(private val player: Player, private val shape: Shape) {

  def getWinner(playedShapeOfOpponent: PlayedShape): Option[Player] = {
    if(shape == playedShapeOfOpponent.shape)
      None
    else
      if (shape.beats(playedShapeOfOpponent.shape)) Some(player) else Some(playedShapeOfOpponent.player)
  }

  def getPlayer = player;

  override def toString(): String = s"${player.getPlayerName}: ${shape}"

}
