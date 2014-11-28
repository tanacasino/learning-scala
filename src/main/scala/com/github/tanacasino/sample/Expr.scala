package com.github.tanacasino.sample

/**
 * Expression＝式を表すcase class
 * コップ本
 */
abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object ExprMain {
  def main(args: Array[String]) {
    val v = Var("x")//newしなくても使える。case classなので。
    println(v)//toStringメソッドが自動実装されているので見やすくVar("x")が出る

    val op = BinOp("+", Number(1), v)
    println(op)

    val op2 = op.copy(operator = "-")//copyメソッドは名前付き引数なので変えたいところだけ指定
    println(op2)

    println(op.right == v)
    println(op.right == Var("x"))

    val uop1 = UnOp("-", UnOp("-", Number(1)))
    println(s"# ${uop1}")
    val simpleExpr = simplifyExpr(uop1)
    println(simpleExpr)
  }

  // 四則演算をする機能をcaseクラスで
  def simplifyExpr(expr: Expr): Expr = {
    expr match {
      case UnOp("-", UnOp("-", value)) => value //
      case BinOp("+", value, Number(0)) => value //0を足してもvalueは変わらず
      case BinOp("*", value, Number(1)) => value //1をかけてもvalueは変わらず
      case _ => expr
    }
  }


}
