package com.github.tanacasino.nnp


trait NNP10 {

  // P01 (*) Find the last element of a list.
  def last(list: List[Int]): Int = {
    list.last
  }

  // P02 (*) Find the last but one element of a list.
  def penultimate(list: List[Int]): Int = {
    list(list.length - 2)
    //list.init.last
    //list.takeRight(2).head
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

  def flatten(nested: List[Any]): List[Any] = {
    ???
  }

  def compress(list: List[Symbol]): List[Symbol] = {
    ???
  }

  def pack(list: List[Symbol]): List[List[Symbol]] = {
    list.foldLeft(Nil:List[List[Symbol]]) {
      case (x :: xs, s) if (x.head == s) => (s :: x) :: xs
      case (ls, s) => List(s) :: ls
    }.reverse
  }

  def encode(list: List[Symbol]): List[(Int, Symbol)] = {
    list.foldLeft(Nil:List[(Int,Symbol)]) {
      case ((ct, sym) :: tail, s) if (sym == s) => (ct + 1, s) :: tail
      case (ls, s) => (1, s) :: ls
    }.reverse
  }
}


