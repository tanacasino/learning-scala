package com.github.hajimeni.rational

import com.github.hajimeni.FizzBuzz
import org.scalatest._

/**
 * Created by nishiyama on 2014/12/05.
 */
class RationalSpec extends FunSpec with Matchers {

  describe("Rational") {
    it ("should Rational + ") {
      (Rational(1, 3) + Rational(1, 3))  should be (Rational(2, 3))
    }

    it ("should compare Rational") {
      val x = Rational(1, 3)
      val y = Rational(2, 3)

      (x < y) should be (right = true)

      val x2 = Rational2(1, 3)
      val y2 = Rational2(2, 3)

      (x2 < y2) should be (right = true)

      val x3 = Rational3(1, 3)
      val y3 = Rational3(2, 3)

      (x3 < y3) should be (right = true)
    }
  }

}
