package com.github.tanacasino.stackable

import collection.mutable


abstract class IntQueue {
  def get(): Int
  def put(x: Int): Unit
}
class BasicIntQueue extends IntQueue {
  val buffer = new mutable.ArrayBuffer[Int]
  def put(x: Int) = buffer += x
  def get(): Int = buffer.remove(0)
}
trait Doubling extends IntQueue {
  abstract override def put(x: Int) = super.put(x * 2)
}
trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = super.put(x + 1)
}
trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if (1 <= x) {
      super.put(x + 1)
    }
  }
}

