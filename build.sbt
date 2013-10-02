name := "RETranslitter"

version := "0.1.0"

scalaVersion := "2.10.2"


libraryDependencies ++= Seq(
    "org.scalacheck" %% "scalacheck" % "1.10.1" % "test",
    "org.scalatest" % "scalatest_2.10" % "2.0.M8" % "test"
)

publishTo := Some(Resolver.file("file", new File("/mnt/repo/prod")))