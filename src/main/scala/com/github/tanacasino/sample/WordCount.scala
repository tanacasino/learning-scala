package com.github.tanacasino.sample

class WordCount {

 def countFruitsFromLines(lines: List[String]): Map[String, Int] = {
   lines
     .flatMap(_.split(" "))
     .groupBy(identity)
     .map{
       case (k, v) => (k, v.size)
     }
 }

  def countFruitsFromLines2(lines: List[String]): Map[String, Int] = {
    lines
      .flatMap(_.split(" "))
      .foldLeft(Map.empty[String, Int]){ case (result, keyword) =>
        result + (keyword -> (result.getOrElse(keyword, 0) + 1))
      }
  }

  def countFruitsFromLines3(lines: List[String]): Map[String, Int] = {
    val words = for {
      line <- lines
      word <- line.split(" ")
    } yield {
      word
    }
    words.groupBy(x => x)
    words.groupBy(_.toString)
    words.groupBy(x => identity(x))
    words.groupBy(identity(_))
    words.groupBy(identity).map(e => e._1 -> e._2.size)
    words.groupBy(identity).map{ case (word, list) => word -> list.size}
  }


}
