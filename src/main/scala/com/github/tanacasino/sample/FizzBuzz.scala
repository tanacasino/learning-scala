package com.github.tanacasino.sample

/**
 * Created by shintaro.tamaki on 2014/11/10.
 */
class FizzBuzz {

  def FizzBuzz(): Seq[String] = {
    (1 to 100).map( i => {
      (i % 3, i % 5) match {
        case (0, 0) => "FizzBuzz"
        case (0, _) => "Fizz"
        case (_, 0) => "Buzz"
        case _ => i.toString
      }
    })
  }
}
