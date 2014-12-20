package com.github.tanacasino.stackable

import org.scalatest._

class IntQueueSpec extends FunSpec with Matchers {


  describe("") {
    describe("") {
      it("should ") {
        val queue = new BasicIntQueue
        queue.put(10)
        queue.put(20)
        queue.get() should be (10)
        queue.get() should be (20)

        val dbQueue = new BasicIntQueue with Doubling
        dbQueue.put(10)
        dbQueue.put(20)
        dbQueue.get() should be (20)
        dbQueue.get() should be (40)

        val dbIncQueue = new BasicIntQueue with Doubling with Incrementing
        dbIncQueue.put(10)
        dbIncQueue.put(20)
        dbIncQueue.get() should be (22)
        dbIncQueue.get() should be (42)
      }
    }

    class DoublingIntQueue extends BasicIntQueue with Doubling with Incrementing
  }

}
