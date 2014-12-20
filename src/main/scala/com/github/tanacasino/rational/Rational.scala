package com.github.tanacasino.rational

// 分数
case class Rational(n: Int, d: Int) {
  def +(that: Rational): Rational = {
    require(this.d == that.d)
    Rational(this.n + that.n, this.d)
  }

  def <(that: Rational): Boolean =
    this.n * that.d < that.n * this.d
  def >(that: Rational): Boolean = that < this
  def <=(that: Rational): Boolean = (this < that) || (this == that)
  def >=(that: Rational): Boolean = (this > that) || (this == that)
}

// インタフェース定義
trait MyComparable[A] {
  def <(that: A): Boolean
  def >(that: A): Boolean
  def <=(that: A): Boolean
  def >=(that: A): Boolean
}

// インタフェースも実装も持つtrait
trait MyComparable2[A] {
  def <(that: A): Boolean
  def >(that: A): Boolean = ! (this <= that)
  def <=(that: A): Boolean = (this < that) || (this == that)
  def >=(that: A): Boolean = (this > that) || (this == that)
}

// オレオレインタフェース実装
case class Rational3(n: Int, d: Int) extends MyComparable2[Rational3] {
  override def <(that: Rational3): Boolean = true
}


// Scalaの Ordered Traitを使った実装
// Javaのjava.lang.Comparable
case class Rational2(n: Int, d: Int) extends Ordered[Rational2] {
  override def compare(that: Rational2): Int =
    (this.n * that.d) - (that.n * this.d)
}

