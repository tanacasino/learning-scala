package com.github.kitaly.Opt

import scala.util.Try

/**
 * Created by kitagawa on 2014/12/17.
 */
case class Request(params: Option[Map[String, String]])

  object Request {
    def difference(req: Request): Option[Int] = {
      for {
        map <- req.params
        start <- map.get("start").flatMap(str => Try(str.toInt).toOption)
        end  <- map.get("end").flatMap(str => Try(str.toInt).toOption) if start <= end
      } yield end - start
    }
  }

