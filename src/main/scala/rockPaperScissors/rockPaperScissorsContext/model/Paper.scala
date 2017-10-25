package rockPaperScissors.rockPaperScissorsContext.model

object Paper extends Shape{
  override def beats(shape: Shape): Boolean = shape match {
    case shape: Rock.type => true
    case _ => false
  }
}
