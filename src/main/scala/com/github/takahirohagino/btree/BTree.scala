package com.github.takahirohagino.btree



sealed trait Node {
  def size: Int
  def sum: Int
}

case class Leaf(n: Int) extends Node {
  def size: Int = 1
  def sum: Int = n
}

case class Branch(left: Node, n: Int, right: Node) extends Node {
  def size: Int = left.size + 1 + right.size
  def sum: Int = left.sum + n + right.sum
}


case class BTree(node: Node) {
  def size = node.size

  def max = {
    def max0(node: Node): Int = node match {
      case Branch(_, _, n: Node) => max0(n)
      case Leaf(x) => x
    }
    max0(node)
  }

  def min = {
    def min0(node: Node): Int = node match {
      case Branch(n: Node, _, _) => min0(n)
      case Leaf(x) => x
    }
    min0(node)
  }

  def sum = node.sum

  def avg: Double = node.sum / node.size

  def find(i: Int): Boolean = {
    def find0(i: Int, node: Node): Boolean = node match {
      case Leaf(n) => if (n == i) true else false
      case Branch(_, n, _) if n == i => true
      case Branch(l, n, _) if n > i => find0(i, l)
      case Branch(_, n, r) if n < i => find0(i, r)
    }
    find0(i, node)
  }
}

// List からNodeを作成する
case class LNode(list: List[Any]) {
  def convert: Node = list match {
    case List(x: Int) => Leaf(x: Int)
    case List(x1:Int, x2: Int, x3:Int) => Branch(Leaf(x1), x2, Leaf(x3))
    case List(x1:List[Any], x2: Int, x3: List[Any]) => Branch(LNode(x1).convert, x2, LNode(x3).convert)
  }
}

// List からBTreeを生成する
case class LBTree(list: List[Any]) {
  def convert = BTree(LNode(list).convert)
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

