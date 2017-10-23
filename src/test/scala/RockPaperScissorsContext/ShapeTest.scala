package RockPaperScissorsContext

import org.scalatest.{BeforeAndAfterEach, FunSuite}

/**
  * Created by sven on 23-10-17.
  */
class ShapeTest extends FunSuite {

  test("Rock beats scissors") {
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
