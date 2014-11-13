package com.github.tanacasino.sample

/**
 * Created by yu.watanabe on 2014/11/12.
 */
object FizzBuzz extends App {

  // 3の倍数でfizz　5の倍数でbuzz　3,5両方の倍数はfizbuzz
  println("###")
  for(i <- 1 to 100) {
    if (i % 3 == 0 && i % 5 == 0) { print("FizzBuzz ") }
    else if (i % 3 == 0) { print("Fizz ") }
    else if (i % 5 == 0) { print("Buzz ") }
    else { print(i + " ") }
  }

  println("###")


}
