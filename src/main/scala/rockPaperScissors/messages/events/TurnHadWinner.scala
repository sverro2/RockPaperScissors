package rockPaperScissors.messages.events

import rockPaperScissors.util.PlayableShape

class TurnHadWinner(val winnerName: String, val winningShape: PlayableShape.Value, val losingShape: PlayableShape.Value) { }
