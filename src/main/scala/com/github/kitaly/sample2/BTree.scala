package com.github.kitaly.sample2

/**
 * Created by kitagawa on 2014/11/28.
 * https://gist.github.com/j5ik2o/7332812
 */
sealed trait Node {
  def size: Int
  def max: Int
  def min: Int
  def sum: Int
  def avg: Float
  def find(x:Int): Option[Node]
}
case class Leaf(value: Int) extends Node {
  def size: Int = 1
  def max: Int = value
  def min: Int = value
  def sum: Int = value
  def avg: Float = value
  def find(x:Int): Option[Node] = if(x == value) Some(this) else None
}
case class Branch(left: Node, value: Int, right: Node) extends Node {
  def size: Int = left.size + 1 + right.size
  def max: Int = List(left.max, value, right.max).max
  def min: Int = List(left.min, value, right.min).min
  def sum: Int = left.sum + value + right.sum
  def avg: Float = sum / size

//  def find(x:Int): Option[Node] = {
//    if (x == value) Some(this)
//    else if (left.find(x).isDefined) left.find(x)
//    else right.find(x)
//  }
  def find(x:Int): Option[Node] = {
    if (x == value) Some(this)
    else left.find(x).orElse(right.find(x))
  }
}

case class BTree(node: Node) {
  def size: Int = node.size
  def max: Int = node.max
  def min: Int = node.min
  def sum: Int = node.sum
  def avg: Float = node.avg
  def find(x:Int): Option[Node] = node.find(x)
}

object BTree {

  /**
   * 1
   * 1, [2], 3
   * 1, 2, 3, [4], 5, 6, 7
   * 1, 2, 3, 4, 5, 6, 7, [8], 9, 10, 11, 12, 13, 14,15
   */
  def apply(list:List[Int]): BTree = {

    def buildNode(ls: List[Int]): Node = {
      ls.length match {
        case 1 => Leaf(ls.head)
        case x if (x >= 3) =>
          val midIndex: Int = (x - 1) / 2
          val mid: Int = ls(midIndex)
          val right: List[Int] = ls.slice(midIndex + 1, x)
          val left: List[Int] = ls.slice(0, midIndex)
          Branch(buildNode(left), mid, buildNode(right))
      }
    }
    BTree(buildNode(list))
  }
}