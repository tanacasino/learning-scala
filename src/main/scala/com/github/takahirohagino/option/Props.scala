package com.github.takahirohagino.option

/**
 * Created by haginum on 12/16/14.
 */
object Props {

  def main(args: Array[String]): Unit = {


    val systemProp = System.getProperty("daily.scala");
    val envProp = System.getenv("DAILY_SCALA");
    val defaultProp = 10;

    def getProp() = {
      Option(systemProp).orElse(Option(envProp)).orElse(Option(defaultProp)).get
    }

    println(getProp())
  }

}
