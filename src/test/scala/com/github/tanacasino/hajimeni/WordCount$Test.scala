package com.github.tanacasino.hajimeni

import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by nishiyama on 2014/11/10.
 */
class WordCount$Test extends FlatSpec with Matchers {

  "A WordCount" should "count each fruit" in {
    val lines = List("apple banana", "orange apple mango", "kiwi papaya orange","mango orange muscat apple")
    val target = new WordCount
    target.countFruitsFromLines(lines) should be (
      Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1)
    )
    target.countFruitsFromLines2(lines) should be (
      Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1)
    )
  }

  
}
