package com.github.tanacasino.btree


sealed trait Node {
  def size: Int
  def max: Int
  def sum: Int
  def avg: Double
  def find(value: Int): Option[Node]
}

case class Leaf(value: Int) extends Node {
  def size: Int = 1
  def max: Int = value
  def sum: Int = value
  def avg: Double = value

  def find(v: Int): Option[Node] = if(v == value) Some(this) else None

}

case class Branch(left:  Node, value: Int, right: Node) extends Node {
  def size: Int = left.size + 1 + right.size
  def max : Int = List(left.max, value, right.max).max
  def max1 : Int = right.max
  def sum: Int = left.sum + value + right.sum
  def avg: Double = sum / size

  def find(v: Int): Option[Node] = v match {
    case n if n == value => Some(this)
    case n if n < value => left.find(n)
    case n => right.find(n)
  }
  def find1(v: Int): Option[Node] = {
    if (v == value) {
      Some(this)
    } else {
      left.find(v).orElse(right.find(v))
    }
  }
}

case class BTree(node: Node) {
  def size: Int = node.size
  def max: Int = {
    @scala.annotation.tailrec
    def max0(n: Node): Int = {
      n match {
        case Branch(_, _, right) => max0(right)
        case Leaf(value) => value
      }
    }
    max0(node)
  }
  def sum: Int = node.sum
  def avg: Double = node.sum / node.size
  def avg1: Double = node.avg
  def find(value: Int): Option[Node] = node.find(value)

  def find2(v: Int): Option[Node] = {
    def find0(i: Int, n: Node): Option[Node] = {
      n match {
        case Leaf(x) => if (x == i) Some(n) else None
        case Branch(_, x, _) if x == i => Some(n)
        case Branch(l, x, _) if i < x => find0(i, l)
        case Branch(_, x, r) if x < i => find0(i, r)
      }
    }
    find0(v, node)
  }
}


object BTree {

  //def apply(node: Node): BTree = BTree(Leaf(1))

  def apply(values: List[Int]): BTree = BTree(toNode(values))

  def toNode(values: List[Int]): Node = {
    if(values.size == 1) {
      Leaf(values.head)
    } else {
      val (left, mid :: right) = values.splitAt(values.size / 2)
      Branch(toNode(left), mid, toNode(right))
    }
  }
}

