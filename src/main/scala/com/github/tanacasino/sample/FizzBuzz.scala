package com.github.tanacasino.sample

import scala.collection.immutable.Range.Inclusive

/**
 * Created by kitagawa on 2014/11/12.
 */
object FizzBuzz extends App {

  val inclusive: Inclusive = 1 to 100
  val list: List[Int] = inclusive.toList
  fizzBuzzForeach(list)

  def fizzBuzzForeach(list: Seq[Int]) :Unit = {
    list.foreach {
      case num if num % 3 == 0 && num % 5 == 0 => println("FizzBuzz")
      case num if num % 3 == 0 => println("Fizz")
      case num if num % 5 == 0 => println("Buzz")
      case num => println(num)
    }
  }
}
