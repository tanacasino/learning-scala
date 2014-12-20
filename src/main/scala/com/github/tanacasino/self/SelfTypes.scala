package com.github.tanacasino.self


object SelfTypes {
  def compileCheck() = {
    (new Food).printAll
  }
}





// Self types その1 selfって名前にする
class Food { self =>

  val all = Seq(1, 2, 3, 4, 5)

  def printAll = self.all foreach println
}









// self に with つけて依存関係を定義する
trait TraitA1 {
  def getA1: Int
}

trait TraitA2 {
  def getA2: String
}

trait TraitA {
  self: TraitA1 with TraitA2 =>

  def getA: String = {
    getA1.toString + getA2
  }
}




// DIチックなやつ
abstract class ControllerBase

trait ABCRepository {
  // RDBやKVSから実際に値取ってくる子
  def findById(id: Long): String = "ABC"
}

trait ABCService {
  self: ABCRepository =>
  def find(id: Long): String = self.findById(id)
}

trait ABCControllerBase extends ControllerBase {
  self: ABCService =>
  def show(id: Long): String = find(id)
}

trait ABCRepository2 extends ABCRepository {
  override def findById(id: Long): String = "MOCK2"
}

class ABCController extends ABCControllerBase with ABCService with ABCRepository2
// ABCServiceがいるよ！でコンパイルエラー

// 定義だけする 基本こいつ使う
//class ABCController extends ABCControllerBase with ABCService with ABCRepository







trait ABCRepositoryMock extends ABCRepository {
  override def findById(id: Long): String = "MockABC"
}

trait ABCServiceMock extends ABCService with ABCRepositoryMock {
  override def find(id: Long): String = findById(id)
}

class TestABController extends ABCControllerBase with ABCServiceMock


class ABCControllerSpec {
  def testABC= {
    val target = new ABCController with ABCServiceMock
    target.show(1L)
  }
}

