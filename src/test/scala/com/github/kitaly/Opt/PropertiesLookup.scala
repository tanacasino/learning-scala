package com.github.kitaly.Opt

/**
 * Created by kitagawa on 2014/12/16.
 */
object PropertiesLookup {
  def lookup() : String =
    Option(System.getProperty("daily.scala")).orElse {
      Option(System.getenv("DAILY_SCALA"))} getOrElse {
      "30"}
}
