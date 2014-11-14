package com.github.tanacasino.sample

import scala.collection.immutable.Range.Inclusive
import scala.util.Try

/**
 * Created by kitagawa on 2014/11/12.
 */
object FizzBuzz extends App {

  fizzBuzzNumSum

  // First
  def fizzBuzzFirst() = {
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

  // Exclude Even Num
  def fizzBuzzExcludeEvenNum = {
    println {
      (1 to 100)
        .filterNot(_ % 2 == 0)
        .map {
        case num if num % 15 == 0 => "FizzBuzz"
        case num if num % 3 == 0 => "Fizz"
        case num if num % 5 == 0 => "Buzz"
        case num => num.toString
      }
      .foreach(println)
    }
  }

  // Comma Separated
  def fizzBuzzCommaSeparate = {
    println {
      (1 to 100)
        .map {
        case num if num % 15 == 0 => "FizzBuzz"
        case num if num % 3 == 0 => "Fizz"
        case num if num % 5 == 0 => "Buzz"
        case num => num.toString
      }
        .mkString(",")
    }
  }

  // Sum
  def fizzBuzzNumSum = {
    println {
      (1 to 100)
        .map {
          case num if num % 15 == 0 => "FizzBuzz"
          case num if num % 3 == 0 => "Fizz"
          case num if num % 5 == 0 => "Buzz"
          case num => num.toString
        }
        .collect {
          case str if Try(str.toInt).isSuccess => str.toInt
        }
        .sum
    }
  }
}

