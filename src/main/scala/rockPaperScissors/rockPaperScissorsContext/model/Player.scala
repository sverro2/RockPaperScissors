package rockPaperScissors.rockPaperScissorsContext.model

abstract class Player {
  def name: String
  def getName = name
  def play()
}
