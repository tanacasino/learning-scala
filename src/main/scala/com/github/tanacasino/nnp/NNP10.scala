package com.github.tanacasino.nnp

import java.util
import collection.JavaConverters._

trait NNP10 {

  // P01 (*) Find the last element of a list.
  def last(list: List[Int]): Int = {
    list.last
  }

  @scala.annotation.tailrec
  final def last1(list: List[Int]): Int = {
    list match {
      case Nil => throw new NoSuchElementException
      case x :: Nil => x
      case x :: xs => last1(xs)
    }
  }

  def last2(list: List[Int]): Int = {
    list.length match {
      case 0 => throw new NoSuchElementException
      case 1 => list.head
      case n => last2(list.tail)
    }
  }

  // P02 (*) Find the last but one element of a list.
  def penultimate(list: List[Int]): Int = {
    list.takeRight(2).head  // 最後の２個をとって頭の要素
    list.init.last          // head : tail == init last
    list(list.length - 2)   //
  }

  @scala.annotation.tailrec
  final def penultimate2(list: List[Int]): Int = {
    list match {
      case Nil => throw new NoSuchElementException
      case x :: Nil => throw new NoSuchElementException
      case x1 :: x2 :: Nil => x1
      case x :: xs => penultimate2(xs)
    }
  }

  def nth(n: Int, list: List[Int]): Int = {
    list(n)
  }

  @scala.annotation.tailrec
  final def nth2(n: Int, list: List[Int]): Int = {
    require(0 <= n)
    require(n <= list.length)
    if(n == 0) {
      list.head
    } else {
      nth2(n - 1, list.tail)
    }
  }

  @scala.annotation.tailrec
  final def nth3(n: Int, list: List[Int]): Int = {
    n match {
      case 0 => list.head
      case i => nth3(i - 1, list.tail)
    }
  }


  def length(list: List[Int]): Int = {
    list.length
  }

  def length2(list: List[Int]): Int = {
    def length0(size: Int, ls: List[Int]): Int = {
      ls match {
        case Nil => size
        case x :: xs => length0(size + 1, xs)
      }
    }
    length0(0, list)
  }

  def reverse(list: List[Int]): List[Int] = {
    list.reverse
  }

  def reverse2(list: List[Int]): List[Int] = {
    @scala.annotation.tailrec
    def reverse0(ls: List[Int], acc: List[Int]): List[Int] = {
      ls match {
        case Nil => acc
        case x :: xs => reverse0(xs, x :: acc)
      }
    }
    reverse0(list, Nil)
  }

  def reverse3(list: List[Int]): List[Int] = {
    list match {
      case head :: Nil => head :: Nil
      case head :: tail => reverse3(tail) ::: head :: Nil
      case Nil => throw new NoSuchElementException
    }
  }

  def isPalindrome(list: List[Int]): Boolean = {
    list == list.reverse
  }

  def compress(list: List[Symbol]): List[Symbol] = {
    @scala.annotation.tailrec
    def compress0(ls: List[Symbol], acc: List[Symbol]): List[Symbol] = {
      ls match {
        case Nil => acc.reverse
        case x :: xs => compress0(xs.dropWhile(_ == x), x :: acc)
      }
    }
    compress0(list, Nil)
  }

  def pack(list: List[Symbol]): List[List[Symbol]] = {
    @scala.annotation.tailrec
    def pack0(acc: List[List[Symbol]], ls: List[Symbol]): List[List[Symbol]] = {
      ls match {
        case Nil => acc
        case l => l.span(_ == l.head) match {
          case (x, Nil) => x :: acc
          case (x, y) => pack0(x :: acc, y)
        }
      }
    }
    pack0(Nil, list).reverse
  }

  def pack2(list: List[Symbol]): List[List[Symbol]] = {
    def pack0(acc: List[List[Symbol]], ls: List[Symbol]): List[List[Symbol]] = {
      ls match {
        case Nil => acc
        case l @ head :: tail =>
          val (x, y) = l.span(_ == head)
          pack0(x :: acc, y)
      }
    }
    pack0(Nil, list).reverse
  }


  def encode2(list: List[Symbol]): List[(Int, Symbol)] = {
    pack2(list).map(l => l.size -> l.head)
  }

  def encode3(list: List[Symbol]): List[(Int, Symbol)] = {
    def encode0(acc: List[(Int, Symbol)], ls: List[Symbol]): List[(Int, Symbol)] = ls match {
      case Nil => acc.reverse
      case l @ head :: _ =>
        val (x, y) = l.span(_ == head)
        encode0((x.size, x.head) :: acc, y)
    }
    encode0(Nil, list)
  }


  def flatten2(nested: List[Any]): List[Any] = {
    @scala.annotation.tailrec
    def flatten0(acc: List[Any], ls: List[Any]): List[Any] = {
      ls match {
        case Nil => acc
        case x :: xs => x match {
          case l: List[_] => flatten0(acc, l ::: xs)
          case v => flatten0(v :: acc, xs)
        }
      }
    }
    flatten0(Nil, nested).reverse
  }

  def flatten3(nested: List[Any]): List[Any] = {
    @scala.annotation.tailrec
    def flatten0(acc: List[Any], ls: List[Any]): List[Any] = {
      ls match {
        case Nil => acc
        case (x: List[_]) :: xs  => flatten0(acc, x ::: xs)
        case (x: Any)     :: xs  => flatten0(x :: acc, xs)
      }
    }
    flatten0(List.empty, nested).reverse
  }

  def flattenByCasino(nested: List[Any]): List[Any] = {
    @scala.annotation.tailrec
    def flatten0(acc: List[Any], ls: List[Any]): List[Any] = {
      ls match {
        case Nil => acc
        case (x: List[_]) :: xs => flatten0(acc, x ::: xs)
        case x :: xs => flatten0(x :: acc, xs)
      }
    }
    flatten0(List.empty, nested).reverse
  }


  def flattenByK(nested: List[Any]): List[Any] = {
    def innerFlatten(acc: List[Any], rest: List[Any]): List[Any] = {
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

  def compress2(list: List[Symbol]): List[Symbol] = {
    @scala.annotation.tailrec
    def compress0(acc: List[Symbol], ls: List[Symbol]): List[Symbol] = {
      ls match {
        case Nil => acc
        case x :: Nil => if (acc.nonEmpty && acc.head == x) acc                else x :: acc
        case x :: xs  => if (acc.nonEmpty && acc.head == x) compress0(acc, xs) else compress0(x :: acc, xs)
      }
    }
    compress0(List.empty, list).reverse
  }

  def compress3(list: List[Symbol]): List[Symbol] = {
    @scala.annotation.tailrec
    def compress0(acc: List[Symbol], ls: List[Symbol]): List[Symbol] = {
      ls match {
        case Nil => acc
        case x :: xs  => compress0(x :: acc, xs.dropWhile(_ == x))
      }
    }
    compress0(List.empty, list).reverse
  }


  def hoge = {
    val javalist = new util.ArrayList[String]()
    javalist.asScala.foreach(println)
    val jlist = List(1,2).asJava
  }
}


