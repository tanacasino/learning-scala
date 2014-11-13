package com.github.tanacasino.sample

import scala.collection.mutable

/**
 * Created by kitagawa on 2014/11/10.
 */
class WordCount {

  def countFruitsFromLines(lines: List[String]): Map[String, Int] = {
    val fruits = lines.map(_.split(" ")).flatten
    val fruitsCountMap: mutable.Map[String, Int] = new mutable.HashMap[String, Int]()
    fruits.foreach(fruit => {
      val count = fruitsCountMap.getOrElse(fruit, 0)
      fruitsCountMap.put(fruit, count + 1)
    })
    fruitsCountMap.toMap
  }

  def countFruitsFromLines2(lines: List[String]): Map[String, Int] = {
    lines.flatMap(_.split(" ")).foldLeft(Map.empty[String, Int]){ case (result, keyword) =>
      result + (keyword -> (result.getOrElse(keyword, 0) + 1))
    }
  }

  def countFruitsFromLines3(lines: List[String]): Map[String, Int] = {
    //    lines.flatMap(_.split(" ")).groupBy(identity).mapValues(fruits => fruits.size)
    //    lines.flatMap(_.split(" ")).groupBy(identity).mapValues(_.size)
    lines.map(_.split(" ")).flatten.groupBy(identity).mapValues(_.size)
  }
}
