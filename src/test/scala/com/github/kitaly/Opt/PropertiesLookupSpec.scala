package com.github.kitaly.Opt

import org.scalatest.{Matchers, FlatSpec}

/**
  * Created by kitagawa on 2014/12/16.
  */
class PropertiesLookupSpec  extends FlatSpec with Matchers {

  "PropertiesLookup" should " find prop in default prop" in {
    PropertiesLookup.lookup() should be ("30")
  }

  "PropertiesLookup" should " find prop in env prop" in {
    PropertiesLookup.lookup() should be ("20")
  }

  "PropertiesLookup" should " find prop in system prop" in {
    System.setProperty("daily.scala", "10")
    PropertiesLookup.lookup() should be ("10")
  }
 }
