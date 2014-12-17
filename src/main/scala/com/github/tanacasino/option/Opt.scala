package com.github.tanacasino.option

import scala.sys.SystemProperties
import scala.util.Try


object Opt {

  def memo = {
    val x = Option("1")
    val y = Option("2")
    val z = None

    x.map { xv =>
      xv.toInt * 2
    } getOrElse 10

    x.fold(10) { xv => xv.toInt * 2 }

    val i = Option(1)
    i.exists(iv => iv % 2 == 0)
    i.find(iv => iv % 2 == 0).map(_ + 1)

    val typeOpt = Some("ats")
    val xx = Option(1).collect { case i if i % 2 == 0 => i.toString }

    val xyz = Option(new java.io.File("hoge/hoge/hoge").listFiles)

    java.lang.System.getProperty("")
    java.lang.System.getenv("")
  }

  def dailyScalaOptionQuiz() = {
    // Tamaki/Maeda
    Option(System.getProperty("daily.scala"))
      .getOrElse(Option(System.getenv("DAILY_SCALA")).getOrElse("10")).toInt

    // Kiyoshi
    Option(System.getProperty("daily.scala"))
      .orElse(Option(System.getenv("DAILY_SCALA"))).orElse(Some("10")).get

    // italy/nishiyama/satou
    Option(System.getProperty("daily.scala"))
      .orElse(Option(System.getenv("DAILY_SCALA"))).getOrElse("10").toInt



    System.getProperty("daily.scala")

    System.getenv("DAILY_SCALA")
  }






  /*
   * Request の params から start と end というパラメータを取得する
   * start と end には 数値の文字列が入っている
   * start が end より大きい数値であることを確認する
   * 最後に end - start を マイナスした値を返す
   * Optionで返す
   * つまり条件外のものは None で
   */
  case class Request(params: Option[Map[String, String]])

  def difference(req: Request): Option[Int] = {
    implicit class RichString(s: String) {
      def toIntOption: Option[Int] = try {
        Some(s.toInt)
      } catch {
        case _: Throwable => None
      }
      def toIntOption2: Option[Int]  = Try(s.toInt).toOption
    }
    for {
      p <- req.params
      sv <- p.get("start").flatMap(_.toIntOption2)
      ev <- p.get("end").flatMap(_.toIntOption2) if sv <= ev
    } yield {
      ev - sv
    }

    req.params.flatMap { p =>
      p.get("start").flatMap { startStr =>
        p.get("end").flatMap { endStr =>
          Try(startStr.toInt).toOption.flatMap { start =>
            Try(endStr.toInt).toOption.map { end =>
              end - start
            }
          }
        }
      }
    }
    for {
      p <- req.params
      startStr <- p.get("start")
      endStr <- p.get("end")
      start <- Try(startStr.toInt).toOption
      end <- Try(endStr.toInt).toOption if start <= end
    } yield end - start
  }



















  def difference2(req: Request): Option[Int] = {
    for {
      params <- req.params
      startString <- params.get("start")
      endString <- params.get("end")
      start <- Try(startString.toInt).toOption
      end <- Try(endString.toInt).toOption
      result <- Some(end - start) if start <= end
    } yield result
  }



  sealed abstract class Error(msg: String)
  case class ParamsNotFoundError(msg: String) extends Error(msg)
  case class ParamNotFoundError(msg: String) extends Error(msg)
  case class InvalidFormatError(msg: String) extends Error(msg)
  case class StartLargeError(msg: String) extends Error(msg)

  def difference3(req: Request): Either[Error, Int] = {
    (for {
      params <- req.params.toRight(ParamsNotFoundError("paramsないよ")).right
      startString <- params.get("start").toRight(ParamNotFoundError("startないよ")).right
      endString <- params.get("end").toRight(ParamNotFoundError("endないよ")).right
      start <- Try(startString.toInt).toOption.toRight(InvalidFormatError("startがIntじゃないよ")).right
      end <- Try(endString.toInt).toOption.toRight(InvalidFormatError("endがIntじゃないよ")).right
    } yield (start , end)) match {
      case Left(error) => Left(error)
      case Right((start, end)) =>
       if(start <= end) Right(end - start) else Left(StartLargeError("startのほうがでかいよー"))
    }
  }

  def quiz = {
    val props = Option(System.getProperty("daily.scala"))
    val env = Option(System.getenv("DAILY_SCALA"))
    val defaultValue = Option("24")
    val dailyScala = props.orElse(env).orElse(defaultValue)
    dailyScala
  }




//
//  case class Request(params: Map[String, String])
//
//  def toIntOption(s: String) = Try(s.toInt).toOption
//
//  def quiz2 = {
//    val req = Request(Map("start" -> "2014", "end" -> "2015"))
//    for {
//      start <- req.params.get("start")
//      startNum <- toIntOption(start)
//      end <- req.params.get("end")
//      endNum <- toIntOption(end)
//      result <- Some(endNum - startNum) if start < end
//    } yield {
//      println(result)
//      result
//    }
}
