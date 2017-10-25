package rockPaperScissors.messages.events

import rockPaperScissors.Util.PlayableShape

class TurnHadWinner(val winnerName: String, val winningShape: PlayableShape.Value, val losingShape: PlayableShape.Value) { }
