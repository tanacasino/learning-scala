package com.github.hajimeni.stackable

import org.scalatest._

/**
 * Created by nishiyama on 2014/12/08.
 */
class IntQueueSpec extends FunSpec with Matchers {

  describe("IntQueue") {
    it("should Queue ") {
      val queue = new BasicIntQueue
      queue.put(10)
      queue.put(20)

      queue.get() should be (10)
      queue.get() should be (20)
    }

    it("should doubling queue") {
      val dbQueue = new BasicIntQueue with Doubling
      dbQueue.put(10)
      dbQueue.put(20)

      dbQueue.get() should be (20)
      dbQueue.get() should be (40)
    }

    it("should doublingInc queue") {
      val dbIncQueue = new BasicIntQueue with Doubling with Incrementing
      dbIncQueue.put(10)
      dbIncQueue.put(20)

      dbIncQueue.get() should be (22)
      dbIncQueue.get() should be (42)
    }

    it("should incDoubling queue") {
      val dbIncQueue = new BasicIntQueue with Incrementing with Doubling
      dbIncQueue.put(10)
      dbIncQueue.put(20)

      dbIncQueue.get() should be (21)
      dbIncQueue.get() should be (41)
    }

  }
}