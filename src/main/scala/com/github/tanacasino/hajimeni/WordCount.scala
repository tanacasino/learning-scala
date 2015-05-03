package com.github.tanacasino.hajimeni

/**
 * Created by nishiyama on 2014/11/10.
 */
class WordCount {
  // 1.varを使ったら負け
  // 2.mutableを使ったから負け
  // 3.while/for ループを使ったら負け
  // 4.nullを使ったら負け
  // 5.Option.getを使ったら負け

  def countFruitsFromLines(lines: List[String]): Map[String, Int] = {
    lines.flatMap(_.split(" ")).groupBy(identity).map {
      case (k, v) => (k, v.length)
    }
  }

  def countFruitsFromLines2(lines: List[String]): Map[String, Int] = {
    lines.flatMap(_.split(" ")).foldLeft(Map.empty[String, Int]){ (result, keyword) =>
      result + (keyword -> (result.getOrElse(keyword, 0) + 1))
    }
  }

}

