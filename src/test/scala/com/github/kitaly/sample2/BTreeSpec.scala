package com.github.kitaly.sample2
import org.scalatest._

/**
 * Created by kitagawa on 2014/12/01.
 */
class BTreeSpec extends FunSpec with Matchers{
  describe("BTree") {
    val bTree1 = BTree(Leaf(1))
    val bTree2 = BTree(Branch(Leaf(1), 2, Leaf(3)))
    val bTree3 = BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7))))
    println(bTree1)
    println(bTree2)
    println(bTree3)

    val size1 = bTree1.size
    val size2 = bTree2.size
    val size3 = bTree3.size
    println(size1)
    println(size2)
    println(size3)

    println(bTree3.max)
    println(bTree3.min)
    println(bTree3.sum)
    println(bTree3.avg)
    println(bTree3.find(4))
    println(bTree3.find(2))
    println(bTree3.find(3))
  }
}
