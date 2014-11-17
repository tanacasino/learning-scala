package com.github.tanacasino.sample

import scala.util.Try

object FizzBuzz extends App {

//  execute1
//  execute3
//  execute4
  execute5

  def execute1 = {
    (1.to(100)).foreach { i =>
      ((i%3), (i%5)) match {
        case (0, 0) => println("FizzBuzz")
        case (0, _) => println("Fizz")
        case (_, 0) => println("Buzz")
        case (_, _) => println(i.toString)
      }
    }
  }

  def execute3 = {
    (1 to 100)
      .filterNot { i => i % 2 == 0 }
      .map { i =>
      ((i%3), (i%5)) match {
        case (0, 0) => "FizzBuzz"
        case (0, _) => "Fizz"
        case (_, 0) => "Buzz"
        case (_, _) => i.toString
      }
    }
    .foreach { println }
  }

  def execute4 = {
    val listFizzBuzz:(Int) => (String) = { i =>
      ((i % 3), (i % 5)) match {
        case (0, 0) => "FizzBuzz"
        case (0, _) => "Fizz"
        case (_, 0) => "Buzz"
        case (_, _) => i.toString
      }
    }
    println((1 to 100).map(listFizzBuzz).mkString(","))
  }

  private def listFizzBuzz(i: Int): String = {
    ((i % 3), (i % 5)) match {
      case (0, 0) => "FizzBuzz"
      case (0, _) => "Fizz"
      case (_, 0) => "Buzz"
      case (_, _) => i.toString
    }
  }

  def execute5 = {
    val result = (1 to 100)
      .map(listFizzBuzz(_))
      .map { i => Try{ i.toInt }.getOrElse(0) }
      .sum
    println(result)
  }

}
