package com.github.tanacasino.sample

/**
 * Created by shintaro.tamaki on 2014/11/10.
 */
class WordCount {

  def countFruitsFromLines(lines: List[String]): Map[String, Int] = {
    //TODO:ここに記述
    lines
      .flatMap(_.split(" "))
      .groupBy(identity)
      .map {
        case (k, v) => (k, v.size)
      }
  }

  def countFruitsFromLines2(lines: List[String]): Map[String, Int] = {
    //TODO:ここに記述
    lines
      .flatMap(_.split(" "))
      .foldLeft(Map.empty[String, Int]) { case (result, keyword) =>
        result + (keyword -> (result.getOrElse(keyword, 0) + 1))
    }
  }

//  def countFruitsFromLines3(lines: List[String]): Map[String, Int] = {
//    //TODO:ここに記述
//    lines.foldLeft(Map.empty[String, Int]) { case (result, line) =>
//      line.split(" ").map( m => {
//        result += (m -> (result.getOrElse(m, 0) + 1))
//      })
//      result
//    }
//  }

  /**
   * 金曜日の勉強会で負けたもの
   * @param lines
   * @return
   */
  def countFruitsFromLinesLoser(lines: List[String]): Map[String, Int] = {
    lines.foldLeft(new scala.collection.mutable.HashMap[String, Int]) { (b, line) =>
      line.split(" ").map( m => {
        val cnt:Int = b.get(m).getOrElse(0) + 1
        b.put(m, cnt)
      })
      b
    }.toMap
  }

}
