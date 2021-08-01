name := "coding-interview-questions"

version := "1.0"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.12.4-js-ec" % "test",
                            "org.specs2" %% "specs2-scalacheck" % "4.12.4-js-ec" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")