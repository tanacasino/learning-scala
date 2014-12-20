package com.github.kitaly.stackable

import collection.mutable


/**
 * Created by kitagawa on 2014/12/08.
 */
abstract class IntQueue {
  def get(): Int
  def put(x: Int): Unit
}

class BasicIntQueue extends IntQueue {
  val buffer = new mutable.ArrayBuffer[Int]

  override def get(): Int = buffer.remove(0)
  override def put(x: Int): Unit = buffer += x
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) = super.put(x * 2)
}
trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = super.put(x + 1)
}
trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if(1 <= x ) super.put(x + 1)
  }
}
