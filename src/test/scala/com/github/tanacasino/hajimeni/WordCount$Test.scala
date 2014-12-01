package com.github.tanacasino.hajimeni

import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by nishiyama on 2014/11/10.
 */
class WordCount$Test extends FlatSpec with Matchers {

  "A WordCount" should "count each fruit" in {
    val lines = List("apple banana", "orange apple mango", "kiwi papaya orange","mango orange muscat apple")
    val target = new WordCount
    target.countFruitsFromLines(lines) should be (
      Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1)
    )
    target.countFruitsFromLines2(lines) should be (
      Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1)
    )
  }

  implicit class Int2Bool(i: Int) {
    def toBool: Boolean = i match {
      case 1 => true
      case 0 => false
      case _ => true
    }
  }


  "Base32" should "bool" in {
    asBase32(List(1,1,1,0,1).map(_.toBool)) should be ("x")
    asBase32(List(1,0,1,0,1).map(_.toBool)) should be ("p")
    asBase32(List(1,1,0,0,0).map(_.toBool)) should be ("s")
    asBase32(List(0,1,0,1,1).map(_.toBool)) should be ("c")
    asBase32(List(0,0,0,0,0).map(_.toBool)) should be ("0")
  }

  "Encode Hash" should "bool list to base32" in {
    val boolList = List(1,1,1,0,1,1,0,1,0,1,1,1,0,0,0,1,1,0,0,0,0,1,0,1,1,0,0,0,0,0).map(_.toBool)

    encodeBits(List.empty, boolList) should be ("xpssc0")
  }

  "Geo Hash" should "hash" in {
    asBit(List.empty, 141.377, 180, -180).map{ case true => 1; case _ => 0 } should be (
      List(1,1,1,0,0,1,0,0,1,0,0,0,1,0,0)
    )

    asBit(List.empty, 43.025, 90, -90).map{ case true => 1; case _ => 0 } should be (
      List(1,0,1,1,1,1,0,1,0,0,1,1,0,0,0)
    )

  }

  "Merge bits" should "Lat and lon" in {
    val lonList = List(1,1,1,0,0,1,0,0,1,0,0,0,1,0,0) // 0,2,4
    val latList = List(1,0,1,1,1,1,0,1,0,0,1,1,0,0,0) // 1,3,5
    val list = lonList.zipAll(latList, 0, 0).flatMap{case(lon, lat) => lon :: lat :: Nil}

    list should be (List(1,1,1,0,1,1,0,1,0,1,1,1,0,0,0,1,1,0,0,0,0,1,0,1,1,0,0,0,0,0))
  }

  "Geo Hash ALl" should "All" in {
    encode(141.377, 43.025, 15) should be ("xpssc0")
  }

  def encode(lon: Double, lat: Double, precise: Int): String = {
    val lonBit = asBit(List.empty, lon, 180, -180)
    val latBit = asBit(List.empty, lat, 90, -90)

    val bitList = lonBit.zipAll(latBit, false, false).flatMap{ case(lon, lat) => lon :: lat :: Nil }
    encodeBits(List.empty, bitList)
  }

  val precise = 5 * 3

  def asBit(acc: List[Boolean], d: Double, max: Double, min: Double): List[Boolean] = {
    acc.length match {
      case l if l >= precise => acc.reverse
      case _ =>
        val mid = (max + min) / 2
        val res = d >= mid
        val (m, n) = if (res) (max, mid) else (mid, min)
        println(s"d=$d, mid=$mid, min=$min, max=$max, flg=$res")
        asBit(res +: acc, d, m, n)
    }
  }

  def asBase32(xs: List[Boolean]): String = {
    val base32 = "0123456789bcdefghjkmnpqrstuvwxyz"
    base32(xs.reverse.zipWithIndex.foldLeft(0.0){ case (n, (b, i)) => if (b) n + Math.pow(2, i) else n }.toInt ).toString
  }

  def encodeBits(acc: List[String], xs: List[Boolean]): String = xs match {
    case Nil => acc.reverse.mkString
    case _ =>
      val (h, t) = xs.splitAt(5)
      encodeBits(asBase32(h) +: acc, t)
  }
  
}

