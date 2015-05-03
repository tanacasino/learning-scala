package com.github.tanacasino.hajimeni

import org.scalatest._

import scala.annotation.tailrec
import scala.util.Try

/**
 * Created by nishiyama on 2014/11/12.
 */
class FizzBuzz$Test extends FlatSpec with Matchers with FizzBuzz {

  "FizzBuzz" should "Fizz Buzz" in {
    val fizzBuzzTestList = 1 to 15
    val target = (1 to 15).map(fizzBuzz)

    target should be {
      Seq("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz")
    }

  }

  "FizzBuzz Program" should "Fizz Buzz" in {
    println("####################################### FizzBuzz 1")
    // その1 FizzBuzz
    (1 to 100)
      .map(fizzBuzz)
      .foreach(println)

    // その2 OneLine
    println("####################################### FizzBuzz 2")
    (1 to 100).map(n => if (n % 15 == 0) "FizzBuzz" else if (n % 5 == 0) "Buzz" else if (n % 3 == 0) "Fizz" else n.toString).foreach(println)

    // その3 2を除外
    println("####################################### FizzBuzz 3")
    (1 to 100)
      .filterNot(n => n % 2 == 0)
      .map(fizzBuzz)
      .foreach(println)

    // その4 カンマ区切り
    println("####################################### FizzBuzz 4")
    println(
      (1 to 100).map(fizzBuzz).mkString(",")
    )

    // その5 Fizz/Buzz/FizzBuzzになっていない数値の足し算
    println("####################################### FizzBuzz 5")
    println(
      (1 to 100)
        .map(fizzBuzz)
        .filterNot( p => p == "FizzBuzz" || p == "Fizz" || p == "Buzz")
        .map(_.toInt)
        .sum
    )

    println(
      (1 to 100)
        .map(fizzBuzz)
        .flatMap(x => Try(x.toInt).toOption)
        .filterNot( p => p == "FizzBuzz" || p == "Fizz" || p == "Buzz")
        .map(_.toInt)
        .sum
    )

    // その6 Listを作らない。 while for 禁止 var 禁止
    println("####################################### FizzBuzz 6")
    @tailrec
    def fizzBuzzPrint(n: Int, stop: Int): Unit = {
      if (n <= stop) {
        println(fizzBuzz(n))
        fizzBuzzPrint(n + 1, stop)
      }
    }
    fizzBuzzPrint(1, 100)
  }

}
