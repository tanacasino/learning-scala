package com.github.tanacasino.nnp


trait NNP10 {

  // P01 (*) Find the last element of a list.
  def last(list: List[Int]): Int = {
    list.last
  }

  def last1(list: List[Int]): Int = {
    // 末尾再帰 tail recursive で最後の値を取る
    // hint: リストの構造に対してパターンマッチする
    //少しつづちっちゃくして最後に残ったら出す
//    list match {
//      // Nil はList.emptyとかいてもいい
//      case Nil => throw new NoSuchElementException // listの長さがzeroの場合
//      case x :: Nil => x // 要素をひとつ取り出したらlistが空になった らxを返して終了
//      case x :: xs => last1(xs)
//    }

    list.length match {
      case 0 => throw new NoSuchElementException
      case 1 => list.head
      case _ => last1(list.tail)
    }
  }

  // P02 (*) Find the last but one element of a list.
  @scala.annotation.tailrec // コンパイル時に末尾再帰かチェックさせるアノテーション。ただしfinalにしなければならない
  final def penultimate(list: List[Int]): Int = {
    //最後から2番めを取り出す
    //list.takeRight(2).head

//    //末尾再帰でやってみる
//    list.length match {
//      case 0 => throw new NoSuchElementException
//      case 1 => throw new NoSuchElementException
//      case 2 => list.head
//      case _ => penultimate(list.tail)
//    }
    //模範解答
    list match {
      // 要素がひとつも無い
      case Nil => throw new NoSuchElementException
      // 要素がひとつだけ
      case x :: Nil => throw new NoSuchElementException
      // 要素が2つ
      case x1 :: x2 :: Nil => x1
      //それいがい
      case x :: xs => penultimate(xs)
    }
  }

  // P03 (*) Find the Kth element of a list. n番目の要素の値を返す
  @scala.annotation.tailrec // コンパイル時に末尾再帰かチェックさせるアノテーション。ただしfinalにしなければならない
  final def nth(n: Int, list: List[Int]): Int = {
    // n番目の値を取り出す（ゼロはじまり
    //list.slice(n, n+1).head //アホかｗ list(n)でよい。
    //list(n)

    //無限ループ発生！不正解
//    list match {
//      // Nil はList.emptyとかいてもいい
//      case Nil => throw new NoSuchElementException // listの長さがzeroの場合
//      case x :: Nil => x // 要素をひとつ取り出してlistが空になったらxを返して終了
//      case x :: xs => nth(x, list)//それ以外,,,ってここおかしくね？
//    }
    n match {
      case 0 => list.head
      //case x => nth(n-1, list.tail) // xとかiとか適当な名前でもよい
      case _ => nth(n-1, list.tail)
    }
  }

  // P04 (*) Find the number of elements of a list.
  def length(list: List[Int]): Int = {
    list.length
    //別解：再帰で
//    def length0(list:List[Int], num:Int) = {
//    }
  }

  // P05 (*) Reverse a list.\
  def reverse(list: List[Int]): List[Int] = {
    list.reverse
  }

  // P06 (*) Find out whether a list is a palindrome.
  // 「たけやぶやけた」みたいな回文になっているかどうか判定
  def isPalindrome(list: List[Int]): Boolean = {
    //単純な方法
    list == list.reverse

    //別解：再帰で書いてみる

  }

  def flatten(nested: List[Any]): List[Any] = {
    // 深くネストしているListを平坦化
    ???
  }

  def compress(list: List[Symbol]): List[Symbol] = {
    // 同じ値が連続している要素をひとつの要素にまとめてゆく
//    if (list(1).equals(list.head)) { compress(list.drop(1)) }
//    list
    ???
  }

  def pack(list: List[Symbol]): List[List[Symbol]] = {
    // compressの逆
    ???
  }

  def encode(list: List[Symbol]): List[(Int, Symbol)] = {
    ???
  }

}


