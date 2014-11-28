package com.github.tanacasino.sample2

/**
 * Created by kitagawa on 2014/11/28.
 */
sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object ExprMain{
  def main (args: Array[String] ) {
    val v = Var("x")
    println(v)

    val op = BinOp("+", Number(1), v)
    println(op)

    val op2 = op.copy(operator = "-")
    println(op2)

    println(op.right == v)
    println(op.right == Var("x"))
    println(op.right == Var("y"))

    val uop1 = UnOp("-", UnOp("-", Number(1)))

    val simpleExpr = simplify(uop1);
    println(simpleExpr)
  }

  def simplify(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", value)) => value
    case BinOp("+", value, Number(0)) =>  value
    case BinOp("*", value, Number(1)) => value
//    case _ => expr
  }
}
