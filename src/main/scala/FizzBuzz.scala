/**
 * Created by takahiro.hagino on 2014/11/12.
 */
object FizzBuzz {

  def main(args: Array[String]): Unit = {

    // One liner
    (1 to 100).map(x => x match { case x if x % 15 == 0 => "FizzBuzz"; case x if x % 5 == 0 => "Buzz"; case x if x % 3 == 0 => "Fizz"; case _ => x.toInt}).foreach(println)


    def fizzBuzz1(x: Int) = {
      x match {
        case x if x % 15 == 0 => "FizzBuzz"
        case x if x %  5 == 0 => "Buzz"
        case x if x %  3 == 0 => "Fizz"
        case _ => x.toString
      }
    }

    // (1 to 100).foreach((x: Int) => println(fizzBuzz1 (x)))


    def fizzBuzz2(range: Range) = {
      range.map(i => (i % 3, i % 5) match {
        case (0, 0) => "FizzBuzz"
        case (_, 0) => "Buzz"
        case (0, _) => "Fizz"
        case _ => i.toString
      }).foreach(println)
    }

    // fizzBuzz2(1 to 100)

  }

}
