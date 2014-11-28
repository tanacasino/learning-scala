package com.github.tanacasino.sample2

/**
 * Created by kitagawa on 2014/11/28.
 */
trait Node {
  // ...
}

case class Branch(left: Node, value: Int, right: Node) extends Node {
  // ...
}

case class Leaf(value: Int) extends Node {
  // ...
}

case class BTree(node: Node) {
  def size: Int = {
  }
}

class BTreeMain {
  def main(args: Array[String]) {
    val bTree1 = BTree(Leaf(1))
    val bTree2 = BTree(Branch(Leaf(1), 2, Leaf(3)))
    val bTree3 = BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7))))

    val size3 = bTree3.size
    println(size3)
  }
}

