package com.github.tanacasino.nnp

import scala.collection.immutable


trait NNP10 {

  /*
  =======================================
  P01 (*) Find the last element of a list.
  =======================================
   */
  def last(list: List[Int]): Int = {
    list.last
  }

  @scala.annotation.tailrec
  final def last1(list: List[Int]): Int = {
    list.length match {
      case 0 => throw new NoSuchElementException
      case 1 => list.head
      case _ => last1(list.tail)
    }
//    list match{
//      case Nil => throw new NoSuchElementException
//      case x :: Nil => x
//      case x :: xs => last1(xs)
//    }
  }


  /*
  ================================================
  P02 (*) Find the last but one element of a list.
  ================================================
 */
  def penultimate(list: List[Int]): Int = {
    list(list.length - 2)
    //list.init.last
    //list.takeRight(2).head
  }

  @scala.annotation.tailrec
  final def penultimate1(list: List[Int]): Int = {
    list.length match {
      case 0 => throw new NoSuchElementException
      case 1 => throw new NoSuchElementException
      case 2 => list.head
      case _ => penultimate1(list.tail)
    }
  }


  /*
  ================================================
  P03 Nth
  ================================================
 */
  def nth(n: Int, list: List[Int]): Int = {
    list(n)
  }

  @scala.annotation.tailrec
  final def nth1(n: Int, list: List[Int]): Int = {
    list match {
      case Nil => throw  new NoSuchElementException
      case x :: xs => if(n == 0) x else nth1(n -1 , xs)
    }
  }


  /*
  ================================================
  P04 Length
  ================================================
  */
  def length(list: List[Int]): Int = {
    list.length
  }

  def length1(list: List[Int]): Int = {
    length1Internal(0, list)
  }

  @scala.annotation.tailrec
  final def length1Internal(acc: Int, list: List[Int]): Int = {
    list match {
      case Nil => acc
      case x :: xs => length1Internal(acc + 1, xs)
    }
  }


  /*
  ================================================
  P05 Reverse
  ================================================
  */
  def reverse(list: List[Int]): List[Int] = {
    list.reverse
  }


  def reverse1(list: List[Int]): List[Int] = {
    reverse1Internal(list, Nil)
  }

  @scala.annotation.tailrec
  final def reverse1Internal(from: List[Int], to: List[Int]): List[Int] = {
    from match {
      case Nil => to
      case _ => reverse1Internal(from.tail, from.head :: to)
    }
  }

  /*
  ================================================
  P06 Palindrome
  ================================================
  */
  def isPalindrome(list: List[Int]): Boolean = {
    list == list.reverse
  }

  /*
  ================================================
  P07 Flatten
  ================================================
  */
  def flatten(nested: List[Any]): List[Any] = {
    @scala.annotation.tailrec
    def flatten0(acc: List[Any], ls:List[Any]): List[Any] = {
      ls match {
        case Nil => acc
        case (x: List[Any]) :: xs => flatten0(acc, x ::: xs)
        case (x: Any) :: xs => flatten0(x :: acc, xs)
      }
    }
    flatten0(Nil, nested).reverse
  }



  /*
    ================================================
    P08 Compress
    ================================================
    */
  def compress(list: List[Symbol]): List[Symbol] = {
    compressInternal(Nil, list)
  }

  @scala.annotation.tailrec
  final def compressInternal(to: List[Symbol], from: List[Symbol]): List[Symbol] = {
    (to, from) match {
      case (_, Nil) => to
      case (Nil, head :: tail) => compressInternal(List(head), tail)
      case (_ :+ last, head :: tail) if last == head => compressInternal(to, tail)
      case (_ :+ last, head :: tail) if last != head => compressInternal(to :+ head, tail)
    }
  }


  /*
    ================================================
    P09 Compress
    ================================================
    */
  def pack(list: List[Symbol]): List[List[Symbol]] = {
    list.foldLeft(Nil: List[List[Symbol]]) {
      case (x :: xs, s) if (x.head == s) => (s :: x) :: xs
      case (ls, s) => List(s) :: ls
    }.reverse
  }

  /*
  ================================================
  P10 Compress
  ================================================
  */
  def encode(list: List[Symbol]): List[(Int, Symbol)] = {
    list.foldLeft(Nil:List[(Int,Symbol)]) {
      case ((ct, sym) :: tail, s) if (sym == s) => (ct + 1, s) :: tail
      case (ls, s) => (1, s) :: ls
    }.reverse
  }
}


