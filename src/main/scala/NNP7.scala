/**
 * Created by takahiro.hagino on 2014/11/19.
 */
object NNP7 {

  // P7 Flatten a nested list structure

  // List( List(1, 2), List(3, 4), List(5, 6), List(List(11, 12), List(21, 22)) )

  def flatten(list: List[Any]): List[Any] = {

    def flatten0 (rslt: List[Any], tls: List[Any]): List[Any] = tls match {
      case Nil => throw new NoSuchElementException
      case x :: Nil => x :: rslt
      case (x :: Nil) :: xs => flatten0(x :: rslt, xs)
      case (h :: t) :: xs => flatten0(h :: rslt, t :: xs)
      case x :: xs => flatten0(x :: rslt, xs)
    }

    // List内にSeq()が含まれる場合は、flatten0を呼び出す
    def flatten1 (list: List[Any]): List[Any] = list match {
      case List(List(_*), _*) => flatten1(flatten0(Nil, list))
      case _ :: List(List(_*), _*) => flatten1(flatten0(Nil, list))
      case _ => 2:: list
    }

    flatten1(list)
  }

  // Listのなかに、Seq()がなくなるまで、flatten0を再帰すれば良くないですか？？

  def isList(elm: Any): Boolean = {
    elm match {
      case Seq() :: xs => true
      case _ => false
    }
  }
}
