package com.github.tanacasino.sample

import org.scalatest._

class FizzBuzzSpec extends FlatSpec with Matchers {

  "A FizzBuzz" should "A FizzBuzz " in {
    println("================ FizzBuzz")
    val target = new FizzBuzz
    target.FizzBuzz().foreach(println)
  }

  "A FizzBuzz3" should "A FizzBuzz3 " in {
    println("================ FizzBuzz3")
    val target = new FizzBuzz
    target.FizzBuzz3().foreach(println)
  }

  "A FizzBuzz4" should "A FizzBuzz4 " in {
    println("================ FizzBuzz4")
    val target = new FizzBuzz
    println(target.FizzBuzz4())
  }

  "A FizzBuzz5" should "A FizzBuzz5 " in {
    println("================ FizzBuzz5")
    val target = new FizzBuzz
    val ret = target.FizzBuzz5()
    println(s"sum = ${ret}")
  }

}

