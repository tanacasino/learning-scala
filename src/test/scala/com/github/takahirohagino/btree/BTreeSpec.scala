package com.github.takahirohagino.btree


import org.scalatest._


class BTreeSpec extends FunSpec with Matchers {

  describe("BTree") {

    describe("Create BTree with Leaf and Branch combination") {
      val bTree1 = BTree(Leaf(1))
      val bTree2 = BTree(Branch(Leaf(1), 2, Leaf(3)))
      val bTree3 = BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7))))

      println(bTree1)
      println(bTree2)
      println(bTree3)

    it("should compute size of BTree") {
        bTree1.size should be (1)
        bTree2.size should be (3)
        bTree3.size should be (7)
      }

    it("should compute sum of BTree") {
        bTree1.sum should be (1)
        bTree2.sum should be (6)
        bTree3.sum should be (28)
      }

    it("should compute max of BTree") {
        bTree1.max should be (1)
        bTree2.max should be (3)
        bTree3.max should be (7)
      }

    it("should compute min of BTree") {
        bTree1.min should be (1)
        bTree2.min should be (1)
        bTree3.min should be (1)
      }

    it("should compute avg of BTree") {
        bTree1.avg should be (1)
        bTree2.avg should be (2)
        bTree3.avg should be (4)
      }

    it("should compute find of BTree") {
        bTree1.find(1) should be (true)
        bTree1.find(2) should be (false)
        bTree2.find(3) should be (true)
        bTree2.find(4) should be (false)
        bTree3.find(4) should be (true)
        bTree3.find(7) should be (true)
        bTree3.find(8) should be (false)
        bTree3.find(0) should be (false)
      }
    }

  }
}
