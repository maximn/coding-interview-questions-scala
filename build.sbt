name := "coding-interview-questions"

version := "1.0"

scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "4.20.5" % "test",
  "org.specs2" %% "specs2-scalacheck" % "4.20.5" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")