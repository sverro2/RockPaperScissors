package RockPaperScissorsContext

abstract class Shape {
  def beats(shape: Shape): Boolean;
  override def equals(shape: Any) = shape.isInstanceOf[this.type]
}
