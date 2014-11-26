package com.github.tanacasino.sample2


class Unapply(val name: String, val age: Int, val dead: Boolean)


object Unapply {

  // ファクトリ
  def apply(name: String, age: Int, dead: Boolean): Unapply = new Unapply(name, age, dead)

  // 抽出子(Extractor)
  def unapply(u: Unapply): Option[(String, Int, Boolean)] = {
    Some((u.name, u.age, u.dead))
  }

}


object UnapplyUsing {

  def use = {
    val u = Unapply("name", 1, false)
    // 抽出！！！
    val Unapply(name, age, dead) = u
    println(name, age, dead)

    val Some((n1, a1, d1)) = Unapply.unapply(u)

    val x = u match {
      // 抽出！ これつまり class ではなく object ？？？
      case Unapply(n, a, d) =>
        (n, a, d)
      case _ => ("", 1, false)
    }
    println(x)

    List(1, 2, 3) match {
      // つまり :: は object/class だと！！！！？
      // ソースコードを読んでみようZE！
      case x :: xs => x
      case _ => 0
    }

    // ちなみに可変長引数をunapply するための unapplySeq というのもあります。Option[List[A]] を返すように作りますです
  }
}

