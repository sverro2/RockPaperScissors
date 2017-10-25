package RockPaperScissors.messages.Events

import RockPaperScissors.Util.PlayableShape

class TurnHadWinner(val winnerName: String, val winningShape: PlayableShape.Value, val losingShape: PlayableShape.Value) { }
