package rockPaperScissorsContext.model

abstract class Shape {
  def beats(shape: Shape): Boolean
  override def equals(shape: Any): Boolean = shape.isInstanceOf[this.type]
  override def toString: String = getClass.getSimpleName
}
