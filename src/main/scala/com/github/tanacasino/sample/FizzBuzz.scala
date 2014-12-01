package com.github.tanacasino.sample

import scala.util.Try

object FizzBuzz {


  def main(args: Array[String]): Unit = {
//    fb1()
//    fb1_2()
//    fb1_3()
//    fb2()
//    fb3()
//    fb3_2()
//    fb4()
//    fb5()
//    fb5_2()
//    fb5_3()
      fb5_5()
      fb5_6()
//    fb6()
//    fizzBuzzPrint(1, 100)
  }

  def toFizzBuzz(n: Int): String = {
    n match {
      case x if x % 15 == 0 => "FizzBuzz"
      case x if x % 3 == 0 => "Fizz"
      case x if x % 5 == 0 => "Buzz"
      case x => x.toString
    }
  }

  def fb1() = {
    (1 to 100)
      .map { n =>
        n match {
          case x if x % 15 == 0 => "FizzBuzz"
          case x if x % 3 == 0 => "Fizz"
          case x if x % 5 == 0 => "Buzz"
          case x => x.toString
        }
      } foreach { s =>
        println(s)
      }
  }

  def fb1_2() = {
    (1 to 100)
      .map {
        case x if x % 15 == 0 => "FizzBuzz"
        case x if x % 3 == 0 => "Fizz"
        case x if x % 5 == 0 => "Buzz"
        case x => x.toString
      }
      .foreach(println)
  }

  def fb1_3() = {
    (1 to 100).map { n =>
      (n % 3 == 0, n % 5 == 0) match {
        case (true, true) => "FizzBuzz"
        case (true, false) => "Fizz"
        case (false, true) => "Buzz"
        case (false, false) => n.toString
      }
    }.foreach(println)
  }

  def fb1_4() = {
    (1 to 100).map { n =>
      (n % 3, n % 5) match {
        case (0, 0) => "FizzBuzz"
        case (0, _) => "Fizz"
        case (_, 0) => "Buzz"
        case _      => n.toString
      }
    }.foreach(println)
  }

  def fb1_5() = {
    (1 to 100)
      .map(toFizzBuzz)
      .foreach(println)
  }

  def fb1_6() = (1 to 100).map(toFizzBuzz).foreach(println)




  // その2 どうでもいいやつ
  def fb2() = {
    (1 to 100).map{n => if(n % 15 == 0) "FizzBuzz" else if(n % 3 == 0) "Fizz" else if(n % 5 == 0) "Buzz" else n.toString }.foreach(println)
  }




  /**
   * その3 2014/11/13 以降
   */

  def fb3() = {
    (1 to 100)
      .filter(_ % 2 != 0)
      .map(toFizzBuzz)
      .foreach(println)
  }

  def fb3_2() = {
    (1 to 100)
      .filterNot(_ % 2 == 0)
      .map(toFizzBuzz)
      .foreach(println)
  }

  def fb3_3() = {
    (1 to 100)
      .withFilter(_ % 2 != 0)
      .withFilter(_ % 7 != 0)
      .map(toFizzBuzz)
      .foreach(println)
  }






  /**
   * その4
   */
  def fb4() = {
    println((1 to 100).map(toFizzBuzz).mkString(","))
  }







  /**
   * その5
   */
  def fb5() = {
    val sum = (1 to 100)
      .map(toFizzBuzz)
      .filter { x =>
        try {
          x.toInt
          true
        } catch {
          case _: Throwable => false
        }
      }
      .map(_.toInt)
      .sum
    println(sum)
  }


  def toIntOption(num: String): Option[Int] = {
    try {
      Some(num.toInt)
    } catch {
      case _: Throwable => None
    }
  }


  def fb5_3() = {
    val sum = (1 to 100)
      .map(toFizzBuzz)
      .map(toIntOption)
      .flatten
      .sum
    println(sum)

    //val a = Try("hoge".toInt)
    // つまり map + flatten == flatMap
    val sum2 = (1 to 100)
      .map(toFizzBuzz)
      .flatMap(toIntOption)
      .sum
    println(sum2)
  }

  def fb5_4() = {
    val sum = (1 to 100)
      .map(toFizzBuzz)
      .foldLeft(0){ (acc, x) =>
        acc + toIntOption(x).getOrElse(0)
      }
    println(sum)
  }

  def fb5_5() = {
    val sum = (1 to 100).map(toFizzBuzz).map(x => Try(x.toInt).getOrElse(0)).sum
    println(sum)
  }

  def fb5_6() = {
    val sum = (1 to 100).map(toFizzBuzz).flatMap(x => Try(x.toInt).toOption).sum
    println(sum)
  }

  /**
   * その6
   */
  def fb6() = {
    val end = 100

    @scala.annotation.tailrec
    def fb0(acc: List[String], current: Int): List[String] = {
      current match {
        case n if end < n => acc
        case n if n % 15 == 0 => fb0("FizzBuzz" :: acc, n + 1)
        case n if n % 3  == 0 => fb0("Fizz" :: acc, n + 1)
        case n if n % 5  == 0 => fb0("Buzz" :: acc, n + 1)
        case n => fb0(n.toString :: acc, n + 1)
      }
    }

    fb0(List.empty, 1).reverse.foreach(println)
  }


  /**
   * hajimeni version
   */
  @scala.annotation.tailrec
  def fizzBuzzPrint(n: Int, stop: Int): Unit = {
    if (n <= stop) {
      println(toFizzBuzz(n))
      fizzBuzzPrint(n + 1, stop)
    }
  }




}
