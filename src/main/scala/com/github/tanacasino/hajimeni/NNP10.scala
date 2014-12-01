package com.github.tanacasino.hajimeni

import scala.annotation.tailrec


trait NNP10 {

  // P01 (*) Find the last element of a list.
  def last(list: List[Int]): Int = {
    list.last
  }

  def last1(list: List[Int]): Int = list match {
    case Nil => throw new NoSuchElementException
    case head :: Nil => head
    case head :: tail => last1(tail)
  }

  // P02 (*) Find the last but one element of a list.
  def penultimate(list: List[Int]): Int = {
    list.init.last
  }

  def penultimate1(list: List[Int]): Int = list match {
    case Nil => throw new NoSuchElementException
    case head :: Nil => head
    case head :: (head2 :: Nil) => head2
    case head :: tail => penultimate1(tail)
  }

  def nth(n: Int, list: List[Int]): Int = {
    list(n)
  }

  def nth1(n: Int, list: List[Int]): Int = list match {
    case Nil => throw new NoSuchElementException
    case head :: tail if n == 0 => head
    case head :: tail => nth1(n - 1, tail)
  }

  def length(list: List[Int]): Int = {
    list.length
  }

  def length1(list: List[Int]): Int = {
    def length0(acc: Int, l: List[Int]): Int = l match {
      case Nil => acc
      case head :: tail => length0(acc + 1, tail)
    }
    length0(0, list)
  }

  def reverse(list: List[Int]): List[Int] = {
    list.reverse
  }

  def reverse1(list: List[Int]): List[Int] = {
    def reverse0(acc :List[Int], l: List[Int]): List[Int] = l match {
      case Nil => acc
      case head :: tail => reverse0(head +: acc, tail)
    }
    reverse0(List.empty[Int], list)
  }

  def isPalindrome(list: List[Int]): Boolean = {
    list == list.reverse
  }

  def isPalindrome1(list: List[Int]): Boolean = list match {
    case Nil => true
    case head :: Nil => true
    case head :: tail if head != tail.last => false
    case head :: tail => isPalindrome1(tail.init)
  }

  def flatten(nested: List[Any]): List[Any] = {

    def listToFlat(result: List[Any], source: List[Any]): List[Any] = {
      source match {
        case Nil => result
        case head::tail => head match {
          case l: List[Any] => listToFlat(result, l ++: tail)
          case _ => listToFlat(head +: result, tail)
        }
      }
    }

    listToFlat(List.empty, nested).reverse

  }

  def compress(list: List[Symbol]): List[Symbol] = {
    def compressList(result: List[Symbol], source: List[Symbol]): List[Symbol] = {
      source match {
        case Nil => result
        case head::tail if result.nonEmpty && result.head == head =>compressList(result, tail)
        case head::tail => compressList(head +: result, tail)
      }
    }
    compressList(List.empty, list).reverse
  }

  def compress1(list: List[Symbol]): List[Symbol] = {
    @tailrec
    def compress0(acc: List[Symbol], ls: List[Symbol]): List[Symbol] = ls match {
      case Nil => acc
      case x :: xs => compress0(x :: acc, xs.dropWhile(_ == x))

    }
    compress0(List.empty[Symbol], list).reverse
  }

  def pack(list: List[Symbol]): List[List[Symbol]] = {
    def packList(result: List[List[Symbol]], source: List[Symbol]): List[List[Symbol]] = {
      source match {
        case Nil => result
        case head::tail if result.nonEmpty && result.head.contains(head) => packList((head +: result.head) +: result.tail, tail)
        case head::tail => packList(List(head) +: result, tail)
      }
    }
    packList(List.empty, list).reverse
  }

  def pack1(list: List[Symbol]): List[List[Symbol]] = {
    def pack0(acc: List[List[Symbol]], ls: List[Symbol]): List[List[Symbol]] = ls match {
      case Nil => acc
      case x :: xs => pack0((x :: xs.takeWhile(_ == x)) :: acc, xs.dropWhile(_ == x))
    }

    pack0(List.empty, list).reverse
  }

  def encode(list: List[Symbol]): List[(Int, Symbol)] = {
    pack(list).map(l => (l.length, l.head))
  }

  def encode1(list: List[Symbol]): List[(Int, Symbol)] = {
    def encode0(acc: List[(Int, Symbol)], ls: List[Symbol]): List[(Int, Symbol)] = ls match {
      case Nil => acc
      case x :: xs => encode0((xs.takeWhile(_ == x).length + 1, x) :: acc, xs.dropWhile(_ == x))
    }
    encode0(List.empty, list).reverse
  }

}


