package com.github.tanacasino.nnp


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

  @scala.annotation.tailrec
  final def last2(list: List[Int]): Int = {
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

  @scala.annotation.tailrec
  final def penultimate3(list: List[Int]): Int = {
    list.length match {
      case 0 => throw new NoSuchElementException
      case 1 => throw new NoSuchElementException
      case 2 => list.head
      case n => penultimate3(list.tail)
    }
  }

  def nth(n: Int, list: List[Int]): Int = {
    list(n)
  }

  @scala.annotation.tailrec
  final def nth2(n: Int, list: List[Int]): Int = {
    require(0 <= n)
    require(n <= list.length)

    if (n == 0) {
      list.head
    }
    else {
      nth2(n - 1, list.tail)
    }
  }

  def length(list: List[Int]): Int = {
    list.length
  }

  def length2(list: List[Int]): Int = {
    @scala.annotation.tailrec
    def length0(size: Int, ls: List[Int]): Int = {
      ls match {
        case Nil => size
        case x :: Nil => size + 1
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

  def isPalindrome(list: List[Int]): Boolean = {
    list == list.reverse
  }

  def flatten(nested: List[Any]): List[Any] = {
    // うーん難しいですねー
//    nested.flatten
    ???
  }

  def compress(list: List[Symbol]): List[Symbol] = {
    @scala.annotation.tailrec
    def compress0(ls: List[Symbol], acc: List[Symbol]): List[Symbol] = {
      ls match {
        case Nil => acc.reverse
        case x :: xs => {
          Some(x) == acc.headOption match {
            case true => compress0(xs, acc)
            case false => compress0(xs, x :: acc)
          }
        }
      }
    }
    compress0(list, Nil)
  }

  def compress2(list: List[Symbol]): List[Symbol] = {
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
    def pack0(ls: List[Symbol], acc: List[List[Symbol]]): List[List[Symbol]] = {
      ls match {
        case Nil => acc.reverse
        case x :: xs => pack0(xs.dropWhile(_ == x), (x :: xs).takeWhile(_ == x) :: acc)
      }
    }
    pack0(list, Nil)
  }

  def encode(list: List[Symbol]): List[(Int, Symbol)] = {
    @scala.annotation.tailrec
    def encode0(ls: List[Symbol], acc: List[(Int, Symbol)]): List[(Int, Symbol)] = {
      ls match {
        case Nil => acc.reverse
        case x :: xs => encode0(xs.dropWhile(_ == x), ((x :: xs).prefixLength(_ == x), x) :: acc)
      }
    }
    encode0(list, Nil)
  }

}


