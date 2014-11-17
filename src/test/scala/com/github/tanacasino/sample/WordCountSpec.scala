package com.github.tanacasino.sample

import org.scalatest._

class WordCountSpec extends FlatSpec with Matchers {

  "A WordCount" should "count each fruit" in {
    val lines = List("apple banana", "orange apple mango", "kiwi papaya orange","mango orange muscat apple")
    val target = new WordCount
//    target.countFruitsFromLines(lines) should be (Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1))
//    target.countFruitsFromLines2(lines) should be (Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1))
//    target.countFruitsFromLines3(lines) should be (Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1))

    val tests = Seq(target.countFruitsFromLines _,
                    target.countFruitsFromLines2 _,
                    target.countFruitsFromLines3 _)
    tests.foreach { test =>
     test(lines) should be (Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1))
    }

    val f: (Int) => String = (x: Int) => x.toString
    Option(null)
  }


  "memo" should "memo" in {
    val lines = List("apple banana", "orange apple mango", "kiwi papaya orange","mango orange muscat apple")
    val target = new WordCount
    target.memo(lines)

  }

}


class Hoge[A] extends Traversable[A]  {
  override def foreach[U](f: (A) => U): Unit = ???
}
