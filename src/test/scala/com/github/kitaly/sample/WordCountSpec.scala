package com.github.kitaly.sample

import org.scalatest._

/**
 * Created by kitagawa on 2014/11/10.
 */
class WordCountSpec extends FlatSpec with Matchers {
  "A WordCount" should "count each fruit1" in {
    val lines = List("apple banana", "orange apple mango", "kiwi papaya orange","mango orange muscat apple")
    val target = new WordCount
    target.countFruitsFromLines(lines) should be (Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1))
  }

  "A WordCount" should "count each fruit2" in {
    val lines = List("apple banana", "orange apple mango", "kiwi papaya orange","mango orange muscat apple")
    val target = new WordCount
    target.countFruitsFromLines2(lines) should be (Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1))
  }

  "A WordCount" should "count each fruit3" in {
    val lines = List("apple banana", "orange apple mango", "kiwi papaya orange","mango orange muscat apple")
    val target = new WordCount
    val map = target.countFruitsFromLines3(lines)
    println(map)
    map should be (Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1))
  }
}
