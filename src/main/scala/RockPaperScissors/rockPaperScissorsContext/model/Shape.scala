package RockPaperScissors.rockPaperScissorsContext.model

abstract class Shape {
  def beats(shape: Shape): Boolean
  def winningShape(shape: Shape): Shape = if(this.beats(shape)) this else shape
  def losingShape(shape: Shape): Shape = if(this.beats(shape)) shape else this
  override def equals(shape: Any): Boolean = shape.isInstanceOf[this.type]
  override def toString: String = getClass.getSimpleName
}
