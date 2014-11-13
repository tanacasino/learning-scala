package com.github.tanacasino.sample

class WordCount {

  // 同じ単語ごとに出現数のmapにする
  def countFruitsFromLines(lines: List[String]): Map[String,Int] = {

//    lines.foreach(line => {
//      line.split(" ").foreach(str => {})
//    })
    // scalaのforeachはループの中で副作用があるときに使えば良い
    // 結果が返ってくるときはMapを使う。結果を返さなくていいときはforeach

    //各要素に対して処理を行いたい(変換するとか)場合はmap
    lines.map(line => { //lineを引数として受け取って、lineをsplitしたものを戻す関数、それがmapの関数の引数となる
      line.split(" ")
    }).find(array => {array.contains("apple")})

    // pattern 1
    lines.flatMap(_.split(" ")).groupBy(identity).map{
      case (k,v) => (k, v.size)
    }.toMap

    // pattern 2
    lines
      .flatMap(_.split(" "))
      .foldLeft(Map.empty[String, Int]) { case (result , keyword) =>
        result + (keyword -> (result.getOrElse(keyword, 0) + 1))
    }

    ???
  }

  def hoge = {
    val seq = Seq(1,2,3)
    seq.map {
      case 1 => "A"
      case 2 => "B"
      case _ => "C"
    }
  }

}
