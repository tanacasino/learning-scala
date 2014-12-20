package com.github.kitaly.stacable

import com.github.kitaly.stackable.{Incrementing, Doubling, BasicIntQueue}
import org.scalatest.{Matchers, FunSpec}

/**
 * Created by kitagawa on 2014/12/08.
 */
class IntQueueSpec extends FunSpec with Matchers {

  describe("BasicIncQueue") {

    describe("Plan"){
      it("shooud xxx"){
        val queue = new BasicIntQueue
        queue.put(10)
        queue.put(20)

        queue.get() should be (10)
        queue.get() should be (20)
      }
    }

    describe("DbInc") {
      it("should xxx"){
        val dbIncQueue = new BasicIntQueue with Doubling with Incrementing
        dbIncQueue.put(10)
        dbIncQueue.put(20)

        dbIncQueue.get() should be (22)
        dbIncQueue.get() should be (42)
      }
    }

    describe("IncDb") {
      it("should xxx") {
        val incDbQueue = new BasicIntQueue with Incrementing with Doubling
        incDbQueue.put(10)
        incDbQueue.put(20)

        incDbQueue.get() should be (21)
        incDbQueue.get() should be (41)
      }
    }
  }
}
