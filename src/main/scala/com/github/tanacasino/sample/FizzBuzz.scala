package com.github.tanacasino.sample

/**
 * Created by yu.watanabe on 2014/11/12.
 */
object FizzBuzz extends App {

  // 3の倍数でfizz　5の倍数でbuzz　3,5両方の倍数はfizbuzz
  println("###")
  for (i <- 1 to 100) {
    if (i % 3 == 0 && i % 5 == 0) {
      print("FizzBuzz,")
    }
    else if (i % 3 == 0) {
      print("Fizz,")
    }
    else if (i % 5 == 0) {
      print("Buzz,")
    }
    else {
      print(i + ",")
    }
  }

  println()
  println("### 2の倍数を除外")
  (1 to 100).toList.filterNot(n => n % 2 == 0).map(n =>
    n match {
      case n if (n % 15 == 0) => "FizzBuzz,"
      case n if (n % 3 == 0) => "Fizz,"
      case n if (n % 5 == 0) => "Buzz,"
      case _ => n
    }
  ).foreach(print(_))

  println()
  println("### その5 fizbuzzなどの文字列になっていない数値の合計値を算出 flatmapなど使って格好よく")
//  val sum (1 to 100).fil
}
