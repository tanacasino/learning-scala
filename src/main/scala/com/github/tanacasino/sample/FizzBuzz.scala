package com.github.tanacasino.sample

/**
 * Created by shintaro.tamaki on 2014/11/10.
 */
class FizzBuzz {

  def FizzBuzz(): Seq[String] = {
    (1 to 100)
      .map( i => {
        (i % 3, i % 5) match {
          case (0, 0) => "FizzBuzz"
          case (0, _) => "Fizz"
          case (_, 0) => "Buzz"
          case _ => i.toString
        }
      })
  }

  def FizzBuzz2(): Seq[String] = {
    // 1行で書く
    (1 to 100).map( i => { if (i % 3 == 0) "Fizz" else i.toString})
  }

  def FizzBuzz3(): Seq[String] = {
    // 2の倍数は除外
    (1 to 100)
      .map( i => {
        (i % 3, i % 5, i % 2) match {
          case (_, _, 0) => None
          case (0, 0, _) => Some("FizzBuzz")
          case (0, _, _) => Some("Fizz")
          case (_, 0, _) => Some("Buzz")
          case _ => Some(i.toString)
        }
      })
      .flatten
  }

  def FizzBuzz3_naoshi(): Seq[String] = {
    // 2の倍数は除外
    (1 to 100)
      .withFilter(_ % 2 != 0) // withFilter は中間リストを作らない
      .map( i => {
      (i % 3, i % 5) match {
        case (0, 0) => "FizzBuzz"
        case (0, _) => "Fizz"
        case (_, 0) => "Buzz"
        case _ => i.toString
      }
    })
  }

  def FizzBuzz4(): String = {
    FizzBuzz()
      .mkString(",")
  }

  def FizzBuzz5(): Long = {
    val list: Seq[String] = FizzBuzz()
    list
      .withFilter(_.matches("""\d+"""))
      .map(_.toInt)
      .sum
  }

}
