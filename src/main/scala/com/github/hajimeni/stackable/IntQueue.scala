package com.github.hajimeni.stackable

import scala.collection.mutable

/**
 * Created by nishiyama on 2014/12/08.
 */
abstract class IntQueue {
  def get(): Int
  def put(x: Int): Unit
}

class BasicIntQueue extends IntQueue {
  val buffer = new mutable.ArrayBuffer[Int]

  def put(x: Int): Unit = {
    buffer += x
  }

  def get(): Int = {
    buffer.remove(0)
  }
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) = super.put(x * 2)
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = super.put(x + 1)
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) = if (x > 0) super.put(x + 1)
}
