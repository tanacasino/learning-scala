package com.github.kitaly.sample2

/**
 * Created by kitagawa on 2014/12/05.
 */
case class Rational (n: Int, d: Int) {

  def +(that: Rational): Rational = {
    require(that.d == this.d)
    Rational(this.n + that.n, this.d);
  }

  def <(thad: Rational): Boolean = this.n * thad.d < thad.n * this.d

  def >(that: Rational): Boolean = that < this
//    this.n * that.d > that.n * this.d

  def <=(that: Rational): Boolean = !(this > that)

  def >=(that: Rational): Boolean = (this > that) || this == that
    //    !(this < that)
    //    this.n * that.d >= that.n * this.d
}

trait Comparable[A] {
  def <(thad: A): Boolean
  def >(that: A): Boolean = !(this <= that)
  def <=(that: A): Boolean = (this > that) || (this == that)
  def >=(that: A): Boolean = (this > that) || (this == that)
}

case class Rational3(n: Int, d: Int) extends Comparable[Rational3]{
  def <(thad: Rational3): Boolean = this.n * thad.d < thad.n * this.d
}