package com.github.tanacasino.nnp

import org.scalatest._


class NNP10Spec extends FunSpec with Matchers with NNP10 {

  describe("Ninety-Nine Scala Problems") {

    // P01 (*) Find the last element of a list.
    describe("P01") {
      it("Find the last element of a list.") {
        last(List(1, 1, 2, 3, 5, 8)) should be (8)
        last1(List(1, 1, 2, 3, 5, 8)) should be (8)
      }
    }

    // P02 (*) Find the last but one element of a list.
    describe("P02") {
      it("Find the last but one element of a list.") {
        penultimate(List(1, 1, 2, 3, 5, 8)) should be (5)
        penultimate2(List(1, 1, 2, 3, 5, 8)) should be (5)
      }
    }

    // P03 (*) Find the Kth element of a list.
    describe("P03") {
      it("Find the Kth element of a list.") {
        nth(2, List(1, 1, 2, 3, 5, 8)) should be (2)
      }
    }

    // P04 (*) Find the number of elements of a list.
    describe("P04") {
      it("Find the number of elements of a list.") {
        length(List(1, 1, 2, 3, 5, 8)) should be (6)
        length2(List(1, 1, 2, 3, 5, 8)) should be (6)
      }
    }

    // P05 (*) Reverse a list.
    describe("P05") {
      it("Reverse a list") {
        reverse(List(1, 1, 2, 3, 5, 8)) should be (List(8, 5, 3, 2, 1, 1))
      }
    }

    // P06 (*) Find out whether a list is a palindrome.
    describe("P06") {
      it("Find out whether a list is a palindrome.") {
        isPalindrome(List(1, 2, 3, 2, 1)) should be (right = true)
      }
    }

    // P07 (**) Flatten a nested list structure.
    describe("P07") {
      it("Flatten a nested list structure.") {
        val nested1 = List(List(1, 1), 2, List(3, List(5, 8)))
        flattenByCasino(nested1) should be (List(1, 1, 2, 3, 5, 8))
        flattenByK(nested1) should be (List(1, 1, 2, 3, 5, 8))
        flatten2(nested1) should be (List(1, 1, 2, 3, 5, 8))
        flatten3(nested1) should be (List(1, 1, 2, 3, 5, 8))

        val nested2 = List(List(1, 1), 2, List(3, List(5, 8)), List(15, List(11, 12), List(13, List(14, 15))))
        flattenByCasino(nested2) should be (List(1, 1, 2, 3, 5, 8, 15, 11, 12, 13, 14, 15))
        flatten2(nested2) should be (List(1, 1, 2, 3, 5, 8, 15, 11, 12, 13, 14, 15))
        //flattenByK(nested2) should be (List(1, 1, 2, 3, 5, 8, 15, 11, 12, 13, 14, 15))
      }
    }

    // P08 (**) Eliminate consecutive duplicates of list elements.
    // If a list contains repeated elements they should be replaced with a single copy of the element.
    // The order of the elements should not be changed.
    describe("P08") {
      it("Eliminate consecutive duplicates of list elements.") {
        compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be (List('a, 'b, 'c, 'a, 'd, 'e))
        compress2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be (List('a, 'b, 'c, 'a, 'd, 'e))
      }

    }

    // P09 (**) Pack consecutive duplicates of list elements into sublists.
    // If a list contains repeated elements they should be placed in separate sublists.
    describe("P09") {
      it("Pack consecutive duplicates of list elements into sublists.") {
        pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be (List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
        pack2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be (List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
      }
    }

    // P10 (*) Run-length encoding of a list.
    // Use the result of problem P09 to implement the so-called run-length encoding data compression method.
    // Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
    describe("P10") {
      it("Run-length encoding of a list.") {
        encode2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be (List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
      }
    }
  }

}
