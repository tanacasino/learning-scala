package com.github.hajimeni.rational

/**
 * Created by nishiyama on 2014/12/05.
 */
case class Rational(n: Int, d: Int) {
  // n ... 分子 d ... 分母
  /**
   * TODO: 一旦、分母があっていた時だけ
   * @param that
   * @return
   */
  def +(that: Rational): Rational = {
    require(this.d == that.d)
    Rational(this.n + that.n, this.d)
  }

  def <(that: Rational): Boolean = {
    this.n * that.d < that.n * this.d
  }

  def >(that: Rational): Boolean = that < this

  def <=(that: Rational): Boolean = (this < that) || (this == that)

  def >=(that: Rational): Boolean = (this > that) || (this == that)

}

case class Rational2(n: Int, d: Int) extends Comparable[Rational2] {
  override def <(that: Rational2): Boolean = (this.n * that.d) < that.n * this.d
}

case class Rational3(n: Int, d: Int) extends Ordered[Rational3] {
  override def compare(that: Rational3): Int = this.n * that.d - that.n * this.d
}

trait Comparable[A] {

  def <(that: A): Boolean
  def >(that: A): Boolean = !(this <= that)
  def <=(that: A): Boolean = (this < that) || (this == that)
  def >=(that: A): Boolean = (this > that) || (this == that)

}
