package com.github.hajimeni.btree

sealed trait Node {
  def size: Int

  def max: Int
  def min: Int
  def sum: Int
  def avg: Double

  def find(n: Int): Option[Node]
}

case class Leaf(value: Int) extends Node {
  def size: Int = 1

  def max: Int = value
  def avg: Double = value
  def min: Int = value
  def sum: Int = value

  override def find(n: Int): Option[Node] = n match {
    case m if n == value => Some(this)
    case _ => None
  }
}

case class Branch(left: Node, value: Int, right: Node) extends Node {
  def size: Int = left.size + 1 + right.size

  def max: Int = List(left.max, value, right.max).max
  def min: Int = List(left.min, value, right.min).min
  def sum: Int = left.sum + value + right.sum
  def avg: Double = sum / size

  def find(n: Int): Option[Node] = n match {
    case m if value == m => Some(this)
    case m if value > m => left.find(n)
    case m if value < m => right.find(n)
  }
}

case class BTree(node: Node) {
  def size: Int = node.size
  def max: Int = node.max
  def min: Int = node.min
  def sum: Int = node.sum
  def avg: Double = node.avg

  def find(n: Int): Option[Node] = {
    node.find(n)
  }
}

object BTree {
  def apply(ls: List[Int]): BTree = {
    def apply0(ls: List[Int]): Node = {
      ls match {
        case Nil => throw new IllegalArgumentException
        case x :: Nil => Leaf(x)
        case _ => {
          val m = ls.size / 2
          val (left, head :: tail) = ls.splitAt(m)
          Branch(apply0(left), head, apply0(tail))
        }
      }
    }
    new BTree(apply0(ls))
  }
}


object BTreeMain {

  def main(args: Array[String]): Unit = {
//    val bTree1 = BTree(Leaf(1))
//    val bTree2 = BTree(Branch(Leaf(1), 2, Leaf(3)))
//    val bTree3 = BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7))))
//
//    println(bTree1)
//    println(bTree2)
//    println(bTree3)
  }

}

