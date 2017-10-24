package rockPaperScissorsContext.model

object Rock extends Shape{
  override def beats(shape: Shape): Boolean = shape match {
    case shape: Scissors.type => true
    case _ => false
  }
}
