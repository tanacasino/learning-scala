package com.github.hajimeni.btree

import org.scalatest._


class BTreeSpec extends FunSpec with Matchers {

  describe("BTree") {

    describe("Create BTree with Leaf and Branch combination") {
      // 0)
      val bTree1 = BTree(Leaf(1))
      val bTree2 = BTree(Branch(Leaf(1), 2, Leaf(3)))
      val bTree3 = BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7))))
      //
      println(bTree1)
      println(bTree2)
      println(bTree3)

      // 1)
      it("should compute size of BTree") {
        bTree1.size should be (1)
        bTree2.size should be (3)
        bTree3.size should be (7)
      }

      // 2)
      it("should calculate  BTree") {
        bTree1.max should be (1)
        bTree1.min should be (1)
        bTree1.sum should be (1)
        bTree1.avg should be (1)

        bTree2.max should be (3)
        bTree2.min should be (1)
        bTree2.sum should be (6)
        bTree2.avg should be (2)

        bTree3.max should be (7)
        bTree3.min should be (1)
        bTree3.sum should be (28)
        bTree3.avg should be (4)
      }

      // 3)
      it("should find in BTree") {
        bTree1.find(1) should be (Some(Leaf(1)))

        bTree2.find(1) should be (Some(Leaf(1)))
        bTree2.find(2) should be (Some(Branch(Leaf(1), 2, Leaf(3))))

        bTree3.find(1) should be (Some(Leaf(1)))
        bTree3.find(2) should be (Some(Branch(Leaf(1), 2, Leaf(3))))
        bTree3.find(4) should be (Some(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7)))))
        bTree3.find(6) should be (Some(Branch(Leaf(5), 6, Leaf(7))))

      }

      // 3+)
      it ("should apply from list") {
        BTree(List(1, 2, 3)) should be (BTree(Branch(Leaf(1), 2, Leaf(3))))
      }

    }

  }
}
