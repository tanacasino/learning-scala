package com.github.tanacasino.nnp

import scala.annotation.tailrec


trait NNP10 {

  // P01 (*) Find the last element of a list.
  def last(list: List[Int]): Int = {
    list.last
  }

  // P02 (*) Find the last but one element of a list.
  def penultimate(list: List[Int]): Int = {
    list.takeRight(2).head  // 最後の２個をとって頭の要素
    list.init.last          // head : tail == init last
    list(list.length - 2)   //
  }

  def nth(n: Int, list: List[Int]): Int = {
    list(n)
  }

  def length(list: List[Int]): Int = {
    list.length
  }

  def reverse(list: List[Int]): List[Int] = {
    list.reverse
  }

  def isPalindrome(list: List[Int]): Boolean = {
    list == list.reverse
  }

  def flattenNotTailrec(nested: List[Any]): List[Any] = {
    def innerFlatten(acc: List[Any], rest: List[Any]):List[Any] = {
       rest match {
         case Nil => acc
         case head :: tail => head match {
           case list: List[_] =>
             val flattenHead = innerFlatten(List(), list.asInstanceOf[List[Any]])
             innerFlatten(flattenHead ::: acc, tail)
           case value: Any =>
             innerFlatten(value :: acc, tail)
         }
       }
    }
    innerFlatten(List(), nested)
      .sortWith((l, r) => l.asInstanceOf[Int] < r.asInstanceOf[Int])
  }

  def flatten(nested: List[Any]): List[Any] = {
    @tailrec
    def innerFlatten(acc: List[Any], rest: List[Any]):List[Any] = {
      rest match {
        case Nil => acc
        case head :: tail => head match {
          case list: List[_] =>
            innerFlatten(acc, list ::: tail)
          case value: Any =>
            innerFlatten(value :: acc, tail)
        }
      }
    }
    innerFlatten(List(), nested).sortBy {
      case i: Int => i
      case any => 0
    }
  }

  def compress(list: List[Symbol]): List[Symbol] = {
    ???
  }

  def pack(list: List[Symbol]): List[List[Symbol]] = {
    ???
  }

  def encode(list: List[Symbol]): List[(Int, Symbol)] = {
    ???
  }

}


