package com.github.tanacasino

package object types {

  // クラス定義
  abstract class BaseTypes

  // フィールド定義
  implicit val hoge = new LearningType

  // 別名定義
  type Rational = com.github.tanacasino.rational.Rational
}
