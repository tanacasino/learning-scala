object NNP {
	def main(args: Array[String]) {

		// P1 Find the last element a list.

    // tailrec アノテーションを使う場合は final キーワードをつける
    // @scala.annotation.tailrec
    // final def last[A](ls: List[A]): A = {
		def last[A](ls: List[A]): A = {
			ls match {
				case head :: Nil => head
				case head :: tail => last(tail)
				case _	=> throw new Exception
			}
		}

    // tail, Nil の部分には必ずListがくるから、名前はなんでもいい。x :: xs っていう書き方をよくやる
    // 比較で使ってる 「::」は実はメソッドではなくクラス（Extractor）

		// P2 Find the last but one element of a list

    // @scala.annotaion.tailrec
		def penultimate[A](ls: List[A]): A = {
			ls match {
        case Nil => throw new NoSuchElementException
        case x :: Nil =>  throw new NoSuchFieldError
				case x1 :: x2 :: Nil => x1
				case x :: xs => penultimate(xs)
			}
		}

		// P3 Find the Kth element of a list

    def nth[A](index: Int, ls: List[A]): A = {
      require(index >= 0 && index < ls.length)
      if (index == 0) ls.head else nth(index - 1, ls.tail)
    }

    def nth2[A](index: Int, ls: List[A]): A = {
      index match {
        case 0 => ls.head
        case n => nth2(n - 1, ls.tail)
      }
		}

    // require : Illigal Argument Exception

		// P4 Find the number of elements of a list
    // 中に関数書かないとできないよね

		def length[A](ls: List[A], cnt: Int = 1): Int = {
			ls match {
				case head :: Nil 	=> cnt
				case _ :: tail 		=> length(tail, cnt + 1)
				case _ 				=> throw new Exception
			}
		}


		// P5 Reverse a list

		def reverse[A](ls: List[A]): List[A] = {
			ls match {
				case head :: Nil	=> head :: Nil
				case head :: tail	=> reverse(tail) ::: head :: Nil
				case _				=> throw new Exception
			}
		}


		// P6 Find out whether a list is a palindrome

		def isPalindrome[A](ls: List[A]): Boolean = ls == ls.reverse

		// P7 Flatten a nested list structure

    /*
		def flatten(ls: List[Any]): List[Any] = {
      def flat(ls: List[Any])(tail: List[Any]): List[Any] = {
        ls match {
          case Nil => throw new NoSuchElementException
          case x :: Nil   => x
          case x :: xs    => x
          case x          => flatten()
        }
      }


      List( List(1, 2), List(3, 4), List(5, 6), List(List(11, 12), List(21, 22)) )
      // 要素を受け取って、リストか、リスト以外の型かをとる
      // accumulator ??
		}
		*/

    /*
    println(flatten(List(2,3,List(11,12),List(21,22))))

		// P8 Eliminate consecutive duplicates of list elements

		def compress(ls: List[Symbol]): List[Symbol] = {

		}

		// P9 Pack consecutive duplicates of list elements into sublists

		def pack(ls: List[Symbol]): List[Symbol] = {

		}

		// P10 Run-length encoding of a list

		def encode(ls: List[Symbol]): List[(Int, Symbol)] = {

		}
*/
	}
}