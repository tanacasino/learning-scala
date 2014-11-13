package com.github.tanacasino.sample

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by yu.watanabe on 2014/11/10.
 */
class WrodCountSpec extends FlatSpec with Matchers {

  "A WordCount" should "count each fruit " in {
    val lines = List("apple banana", "orange apple mango", "kiwi papaya orange","mango orange muscat apple")
    val target = new WordCount
    target.countFruitsFromLines(lines) should be (
      Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1))
  }

}
