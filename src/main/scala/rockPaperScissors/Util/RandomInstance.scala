package rockPaperScissors.Util

object RandomInstance {
  val random = new scala.util.Random(System.currentTimeMillis())
  def getNextInt(maximum: Int) = random.nextInt(maximum)
}
