package com.github.tanacasino.sample2


class Klass(name: String, age: Int) {

  // デフォルトコンストラクタ内の処理になる 基本コンストラクタ
  val first = name.split(" ")(0)
  val last = name.split(" ")(1)

  // デフォルトコンストラクタ以外のものを宣言する
  def this(name: String) = {
    this(name, 1)
  }

}
