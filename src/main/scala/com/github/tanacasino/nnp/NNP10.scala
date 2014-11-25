package com.github.tanacasino.nnp

import scala.annotation.tailrec


trait NNP10 {

  // P01 (*) Find the last element of a list.
  def last(list: List[Int]): Int = {
//    list.reverse.head
    list.last
  }

  @tailrec
  final def last1(list: List[Int]): Int = {
//    list.tail match {
//      case Nil => list.head
//      case list => last1(list.tail)
//    }

    list match {
      case Nil => throw new NoSuchElementException
      case x :: Nil => x
      case x :: xs => last1(xs)
    }
  }

  // P02 (*) Find the last but one element of a list.
  def penultimate(list: List[Int]): Int = {
    // head<=>tail == init<=>last
    list.init.last
  }

  @tailrec
  final def penultimate1(list: List[Int]): Int = {
    list match {
      case Nil => throw new NoSuchElementException
      case x :: Nil => throw new IllegalStateException
      case x1 :: x2 :: Nil => x1 // この行忘れてた
      case x :: xs => penultimate1(xs)
    }
  }

  def nth(n: Int, list: List[Int]): Int = {
    list(n)
  }

  @tailrec
  final def nth1(n: Int, list: List[Int]): Int = {
    n match {
      case 0 => list.head
      case _ => nth1(n-1, list.tail)
    }
  }

  def length(list: List[Int]): Int = {
    list.length
  }

  def length1(list: List[Int]): Int = {
    @tailrec
    def length0(n: Int, list0: List[Int]): Int = {
      list0 match {
        case Nil => throw new NoSuchElementException
        case x :: Nil => n+1
        case x :: xs => length0(n+1, xs)
      }
    }
    length0(0,list)
  }

  def reverse(list: List[Int]): List[Int] = {
    list.reverse
  }

  def reverse1(list: List[Int]): List[Int] = {
    @tailrec
    def reverse0(acc: List[Int], list0: List[Int]): List[Int] = {
      list0 match {
        case Nil => throw new NoSuchElementException
        case x :: Nil => acc.::(x)
//        case x :: xs => reverse0(acc.::(x), xs)
        case x :: xs => reverse0(x :: acc, xs)
      }
    }
    reverse0(List.empty, list)
  }

  def isPalindrome(list: List[Int]): Boolean = {
    list == list.reverse
  }

  def flatten(nested: List[Any]): List[Any] = {
//    nested.flatten(List[Any])
    

    ???
  }

  def compress(list: List[Symbol]): List[Symbol] = {
    @tailrec
    def compress0(acc: List[Symbol], list0: List[Symbol]): List[Symbol] = {
      list0 match {
        case Nil => acc.reverse
//        case x :: xs => compress0(x :: acc, xs.dropWhile(a => a == x))
        case x :: xs => compress0(x :: acc, xs.dropWhile(_ == x))
      }
    }
    compress0(List.empty, list)
  }

  def pack(list: List[Symbol]): List[List[Symbol]] = {
    @tailrec
    def pack0(acc: List[List[Symbol]], list0: List[Symbol]): List[List[Symbol]] = {
      list0.span(_ == list0.head) match {
        case (x, Nil) => (x :: acc).reverse
        case (x, y) => pack0(x :: acc, y)
      }
    }
    pack0(List.empty, list)
  }

  def encode(list: List[Symbol]): List[(Int, Symbol)] = {
    @tailrec
    def encode0(acc: List[(Int, Symbol)], list0: List[Symbol]): List[(Int, Symbol)] = {
      list0.span(_ == list0.head) match {
        case (x, Nil) => ((x.length, list0.head) :: acc).reverse
        case (x, y) => encode0((x.length, x.head) :: acc, y)
      }
    }
    encode0(List.empty, list)
  }

}


