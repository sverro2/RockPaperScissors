package rockPaperScissorsContext

object Scissors extends Shape{
  override def beats(shape: Shape): Boolean = shape match {
    case shape: Paper.type => true
    case _ => false
  }
}
