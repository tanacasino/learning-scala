package com.github.kitaly.sample2

import org.scalatest.{Matchers, FunSpec}

/**
 * Created by kitagawa on 2014/12/05.
 */
class RationalSpec extends FunSpec with Matchers{
  describe("Rational") {
    describe("Plus") {
      it("should return new rational"){
        val x = Rational(1,3);
        val y = Rational(1,3);
        println(x, y);

        x + y should be (Rational(2,3))
      }
    }

    describe("compare"){
      it("should return boolean"){
        val x = Rational(1,3);
        val y = Rational(2,3);
        val z = Rational(1,3);
        x > y should be (false);
        x < y should be (true);
        x >= y should be (false);
        x <= y should be (true);
        x > z should be (false);
        x < z should be (false);
        x >= z should be (true);
        x <= z should be (true);
      }
    }
  }

  describe("Rational3"){
    describe("compare"){
      it("should return boolean"){
        val x = Rational3(1,3);
        val y = Rational3(2,3);
        val z = Rational3(1,3);
        x > y should be (false);
        x < y should be (true);
        x >= y should be (false);
        x <= y should be (true);
        x > z should be (false);
        x < z should be (false);
        x >= z should be (true);
        x <= z should be (true);
      }
    }
  }
}
