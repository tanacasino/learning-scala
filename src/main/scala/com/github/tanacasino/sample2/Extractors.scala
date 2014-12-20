package com.github.tanacasino.sample2

class Extractors(val name: String, val age: Int, val dead: Boolean)


object Extractors {

  // ファクトリ
  def apply(name: String, age: Int, dead: Boolean): Extractors = new Extractors(name, age, dead)

  // 抽出子(Extractor)
  def unapply(u: Extractors): Option[(String, Int, Boolean)] = {
    Some((u.name, u.age, u.dead))
  }

}


object ExtractorsUsing {

  def use = {
    val u = Extractors("name", 1, false)
    // 抽出！！！
    val Extractors(name, age, dead) = u
    println(name, age, dead)

    val Some((n1, a1, d1)) = Extractors.unapply(u)

    val x = u match {
      // 抽出！ これつまり class ではなく object ？？？
      case Extractors(n, a, d) =>
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

