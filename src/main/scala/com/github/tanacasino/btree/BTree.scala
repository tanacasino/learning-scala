package com.github.tanacasino.btree



sealed trait Node

case class Leaf() extends Node

case class Branch() extends Node

case class BTree(node: Node)


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

