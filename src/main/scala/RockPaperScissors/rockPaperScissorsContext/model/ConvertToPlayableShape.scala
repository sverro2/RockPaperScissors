package RockPaperScissors.rockPaperScissorsContext.model

import RockPaperScissors.Util.PlayableShape

object ConvertToPlayableShape {
  def apply(shape: Shape): PlayableShape.Value =
    if(shape == Rock) PlayableShape.Rock
    else if(shape == Paper) PlayableShape.Paper
    else if(shape == Scissors) PlayableShape.Scissors
    else throw new IllegalArgumentException("Shape could not be converted to PlayableShape (not recognized)")
}
