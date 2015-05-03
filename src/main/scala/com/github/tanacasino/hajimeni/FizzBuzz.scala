package com.github.tanacasino.hajimeni

/**
 * Created by nishiyama on 2014/11/12.
 */
trait FizzBuzz {
  def fizzBuzz(n: Int): String = n match {
    case m if m % 15 == 0 => "FizzBuzz"
    case m if m % 5 == 0 => "Buzz"
    case m if m % 3 == 0 => "Fizz"
    case _ => n.toString
  }
}
