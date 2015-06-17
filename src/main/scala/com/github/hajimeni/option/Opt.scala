package com.github.hajimeni.option

import scala.util.Try

/**
 * Created by nishiyama on 2014/12/15.
 */
object Opt {
  def quiz01 = {
    val x = Option("1")
    val y = Option("2")
    val z = None

    x.fold(10) { xv => xv.toInt * 2}
    x.map(_.toInt).getOrElse(10)

    val i = Option(1)
    // p = predicate function(述語関数)
    i.filter(p => p % 2 == 0).map(_ + 1)
    i.find(p => p % 2 == 0).map(_ + 1)
  }

  val startParamName = "start"
  val endParamName = "end"

  implicit class OptionString(s: Option[String]) {
    def toIntOption: Option[Int] = try{ s.map(_.toInt) } catch { case e: Throwable => None}
  }

  def difference(req: Request): Option[Int] = {
    for {
      p <- req.params
      sv <- p.get(startParamName).toIntOption
      ev <- p.get(endParamName).toIntOption if sv < ev
    } yield {
      ev - sv
    }
  }

}

case class Request(params: Option[Map[String, String]])