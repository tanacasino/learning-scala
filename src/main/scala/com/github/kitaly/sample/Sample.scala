package com.github.kitaly.sample

import java.util

class Sample {
  def hello(word: String): String = {
    s"Hello, $word!"
  }


  def fuga = {
    Option(new util.HashMap[String, String]().get("key")).foreach(println)
  }

}

