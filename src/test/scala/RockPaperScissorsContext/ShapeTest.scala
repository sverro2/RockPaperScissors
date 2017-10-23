package RockPaperScissorsContext

import org.scalatest.{FunSuite}

class ShapeTest extends FunSuite {

  test("Rock beats Scissors") {
    assert(Rock.beats(Scissors) === true)
  }

  test("Scissors beats Paper") {
    assert(Scissors.beats(Paper) === true)
  }

  test("Paper beats Rock") {
    assert(Paper.beats(Rock) === true)
  }

  test("Scissors does not beat Rock") {
    assert(Scissors.beats(Rock) === false)
  }

  test("Rock does not beat Rock") {
    assert(Rock.beats(Rock) === false)
  }

  test("Rock equals Rock") {
    assert(Rock == Rock === true)
  }

  test("Paper does not equal Rock") {
    assert(Paper != Rock === true)
  }

}
