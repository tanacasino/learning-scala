package com.github.tanacasino.sample2

// private をつけるとコンストラクタが他のクラスから呼べないやつになりますJavaでもやりますよね！Singleton パターンなどで。
class CompanionA private (name: String, age: Int) {

  // お互いにprivateメンバーにアクセス可能です
  def say = CompanionA.PrivateValue

  def fire = {
    CompanionA.staticMethod
  }

}


object CompanionA {

  private val PrivateValue = "PrivateValue"

  // ファクトリを定義する
  def apply(name: String, age: Int): CompanionA = {
    new CompanionA(name, age)
  }

  private def staticMethod = "static!!!"

}
