package com.github.tanacasino.sample

import collection.mutable.Stack
import org.scalatest._

class SampleSpec extends FlatSpec with Matchers {

  "A Sample" should "returns hello message with specified word" in {
    val sample = new Sample
    val word = "すから"
    sample.hello(word) should be (s"Hello, $word!")
  }

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }
  }
}

