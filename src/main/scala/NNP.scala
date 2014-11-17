object NNP {
	def main(args: Array[String]) {

		// P1 Find the last element a list.

		def last[A](ls: List[A]): A = {
			ls match {
				case head :: Nil => head
				case head :: tail => last(tail)
				case _	=> throw new Exception
			}
		}

		// P2 Find the last but one element of a list

		def penultimate[A](ls: List[A]): A = {
			ls match {
				case head :: _ :: Nil => head
				case head :: tail => penultimate(tail)
				case _ => throw new Exception
			}
		}

		// P3 Find the Kth element of a list

		def nth[A](index: Int, ls: List[A]): A = {
			require(index >= 0 && index < ls.length)
			if (index == 0) ls.head else nth(index - 1, ls.tail)
		}

		// P4 Find the number of elements of a list

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

		def flatten(ls: List[Any]): List[Any] = {
      ls.flatten
		}

    /*
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