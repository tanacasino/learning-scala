package com.github.tanacasino.sample

import org.scalatest._

class FizzBuzzSpec extends FlatSpec with Matchers {

  "A FizzBuzz" should " " in {
    val target = new FizzBuzz
    target.FizzBuzz().map(
      println(_)
    )
  }
}

