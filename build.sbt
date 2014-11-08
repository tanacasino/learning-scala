import sbtassembly.Plugin._
import AssemblyKeys._

name := "learning-scala"

version := "0.0.1"

scalaVersion := "2.11.4"

organization := "com.github.tanacasino"

scalacOptions ++= Seq("-unchecked", "-deprecation")

libraryDependencies ++= {
  Seq(
   "org.scalatest"  % "scalatest_2.11" % "2.2.1" % "test"
  )
}

resolvers ++= Seq(
  "snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases"      at "http://oss.sonatype.org/content/repositories/releases"
)

assemblySettings
