package com.github.kitaly.Opt

/**
 * Created by kitagawa on 2014/12/15.
 */
class Opt {

  def quiz01 = {
    val x = Option("1")
    val y = Option("2")
    val z = None

    x.map { xv =>
      xv.toInt * 2
    } getOrElse 10

    x.fold(10) {xv => xv.toInt * 2}

    val i = Option(1)
    i.exists(iv => iv % 2 == 0)
  }
}
