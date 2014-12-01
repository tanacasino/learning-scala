package com.github.tanacasino.sample2

/**
 * Created by tomofumi.tanaka on 2014/11/26.
 */
class CompanionB {

  def createCompanionA = {
//    val ca1 = new CompanionA("a", 1)  // コンパイルできない
    val ca2 = CompanionA("a", 1)

//    val p = CompanionA.PrivateValue   // コンパイルできない
  }
}

