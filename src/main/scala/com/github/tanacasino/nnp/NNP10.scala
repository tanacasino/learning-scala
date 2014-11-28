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
    //list.length
    //別解：再帰で
    def length0(list0:List[Int], num:Int): Int = {
      list0 match {
        case Nil => num
        case x => length0(x.tail, num + 1) // tailは
      }
    }
    length0(list, 0)
  }

  // P05 (*) Reverse a list.\
  def reverse(list: List[Int]): List[Int] = {
    // 単純な方法
    //list.reverse
    // 別解：再帰で
    def reverse0(ls:List[Int], acc: List[Int]): List[Int] = {
      ls match {
        case Nil => acc
        case _ => reverse0(ls.tail, ls.head :: acc)
      }
    }
    reverse0(list, Nil)
  }

  // P06 (*) Find out whether a list is a palindrome.
  // 「たけやぶやけた」みたいな回文になっているかどうか判定
  def isPalindrome(list: List[Int]): Boolean = {
    //単純な方法
    list == list.reverse
    //別解：再帰で書いてみる
  }

  // P07 (**) Flatten a nested list structure.
  // flatten(List(List(1, 1), 2, List(3, List(5, 8)))) should be (List(1, 1, 2, 3, 5, 8))
  def flatten(nested: List[Any]): List[Any] = {
    // 深くネストしているListを平坦化
    // 模範解答ここから
    def flatten0(acc: List[Any], ls: List[Any]): List[Any] ={
      ls match {
        case Nil => acc
        case (x: List[_]) :: Nil => flatten0(acc, x)
        case (x: Any) :: Nil => x :: acc
        case (x: List[_]) :: xs => flatten0(acc, x ::: xs)
        case (x: Any) :: xs => flatten0(x :: acc, xs)
      }
    }
    flatten0(List.empty, nested).reverse
    // 模範解答ここまで
  }

  // P08 (**) Eliminate consecutive duplicates of list elements.
  // 同じ値が連続している要素をひとつの要素にまとめてゆく
  //compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be (List('a, 'b, 'c, 'a, 'd, 'e))
  def compress(list: List[Symbol]): List[Symbol] = {
    @scala.annotation.tailrec
    def compress0(list0: List[Symbol], acc: List[Symbol]): List[Symbol] = {
      list0 match {
        case Nil => acc
        case _ => {
          if (!acc.isEmpty && acc.head == list0.head) compress0(list0.tail, acc)
          else compress0(list0.tail, list0.head :: acc)
        }
        // 模範解答はこれらしい
        // case Nil => acc.reverse
        // case x :: xs => compress0(xs.dropWhile(a => a == x), x::acc)
      }
    }
    compress0(list,Nil).reverse
  }

  // P09 (**) Pack consecutive duplicates of list elements into sublists.
  // pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be (List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  def pack(list: List[Symbol]): List[List[Symbol]] = {
    @scala.annotation.tailrec
    def pack0(ls: List[Symbol], acc:List[List[Symbol]]): List[List[Symbol]] = {
      ls match {
        case Nil => acc
        case _ => {
          acc match {
            case Nil =>
              pack0(ls.tail, List(ls.head) :: acc)
            case x :: xs => {
              if (x.head == ls.head) {
                pack0(ls.tail, acc.updated(0, ls.head +: acc.head))
              } else {
                pack0(ls.tail, List(ls.head) :: acc)
              }
            }
          }
        }
      }
    }
    pack0(list, Nil).reverse
  }

  // P10
  //encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be (List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  def encode(list: List[Symbol]): List[(Int, Symbol)] = {
    def encode0(ls: List[Symbol], acc: List[(Int, Symbol)]): List[(Int, Symbol)] = {
      ls match {
        case Nil => acc
        case _ => {
          acc match {
            case Nil => encode0(ls.tail, List((1, ls.head)))
            case x :: xs => {
              if (x._2 == ls.head) encode0(ls.tail, acc.updated(0, (x._1 + 1, ls.head)))
              else encode0(ls.tail, (1,ls.head) :: acc)
            }
          }
        }
      }
    }
    encode0(list, Nil).reverse
  }

}


