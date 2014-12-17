package com.github.takahirohagino.option

/**
 * Created by haginum on 12/17/14.
 */
case class Request (val params: Option[Map[String, String]]) {

  val default: Map[String, String] = Map("start" -> "0", "end" -> "0")
  val start = params.getOrElse(default).getOrElse("start", "10").toInt
  val end = params.getOrElse(default).getOrElse("end", "10").toInt
  val result = if (start > end) Some(end - start) else None

  def getResult = result;

}

object Main {
  def main(args: Array[String]): Unit = {
    println(Request(Some(Map("start" -> "10", "end" -> "2"))).getResult);
  }
}
