package com.github.tanacasino.implicits

trait Adder[A] {
  def add(x: A, y: A): A
}


case class Person(firstName: String, lastName: String)

object Implicits {

}

object ImplicitAdder {

  def add[A](x: A, y: A)(implicit adder: Adder[A]): A = {
    adder.add(x, y)
  }


  def main(args: Array[String]) {
    implicit val intAdder = new Adder[Int] {
      def add(x: Int, y: Int): Int = x + y
    }

    implicit val stringAdder = new Adder[String] {
      def add(x: String, y: String): String = x + y
    }

    implicit val hanakoAdder = new Adder[Person] {
      def add(x: Person, y: Person): Person = {
        x.copy(firstName = y.firstName)
      }
    }

    println(add(1, 3))
    println(add("a", "b"))

    val tarou =  Person("tarou", "yamada")
    val hanako = Person("hanako", "tanaka")

    println(add(tarou, hanako))
  }
}
