package com.github.tanacasino.option

import com.github.tanacasino.option.Opt.{ParamsNotFoundError, Request}
import org.scalatest._

class OptSpec extends FunSpec with Matchers {

  describe("Opt.difference2") {
    describe("endのほうがstartより大きい場合") {
      val params = Map("start" -> "2014", "end" -> "2015")
      it("ちゃんと差分を返す") {
        val req = Request(Some(params))
        Opt.difference2(req) should be (Some(1))
      }
    }

    describe("paramsがない場合") {
      it("Noneを返す") {
        val req = Request(None)
        Opt.difference2(req) should be (None)
      }
    }

    describe("params内のstart/end がない場合") {
      it("Noneを返す") {
        Opt.difference2(Request(Some(Map()))) should be (None)
        Opt.difference2(Request(Some(Map("start" -> "2014")))) should be (None)
        Opt.difference2(Request(Some(Map("end" -> "2015")))) should be (None)
      }
    }
  }

  describe("Opt.difference3") {
    describe("endのほうがstartより大きい場合") {
      val params = Map("start" -> "2014", "end" -> "2015")
      it("ちゃんと差分を返す") {
        val req = Request(Some(params))
        Opt.difference3(req) should be(Right(1))
      }
    }

    describe("paramsがない場合") {
      it("Noneを返す") {
        val req = Request(None)
        Opt.difference3(req) should be (Left(ParamsNotFoundError("paramsないよ")))
      }
    }
  }

}
