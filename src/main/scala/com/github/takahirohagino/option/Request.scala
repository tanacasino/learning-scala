package com.github.takahirohagino.option

/**
 * Created by haginum on 12/17/14.
 */
case class Request (val params: Option[Map[String, String]]) {

  private val default: Map[String, String] = Map("start" -> "0", "end" -> "0")
  private val start = params.getOrElse(default).getOrElse("start", "10").toInt
  private val end = params.getOrElse(default).getOrElse("end", "10").toInt
  val result = if (start > end) Some(end - start) else None

}


object Main {
  def main(args: Array[String]): Unit = {
    println(difference(Request(Some(Map("start" -> "10", "end" -> "2")))));
  }

  def difference(req: Request): Option[Int] = req.result
}
