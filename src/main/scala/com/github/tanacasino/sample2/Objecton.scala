package com.github.tanacasino.sample2

// Singleton のオブジェクト相当のものになります
object Objecton {


  // static メソッドのようになります HogeUtils.class とかとしても使えますね
  def hoge = "hoge"

  // static なvalueになるので 定数宣言としても扱えますね
  val DefaultMaxValue = 1000

  // ネームスペースの役割として クラスも作れます
  // public static class 相当でしょうかね？
  class Inner(val name: String, val age: Int)

}


class Hoge {
  def hoge = {
    // Objectのメンバーはimport できるのでネームスペースとしての役割もできます。
    // その2。Implicits._ みたいなパターンはStanbyでもslickで見ますよね？
    import Objecton._

    println(DefaultMaxValue)
    // Inner
  }
}


