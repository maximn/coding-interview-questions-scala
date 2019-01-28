name := "coding-interview-questions"

version := "1.0"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.4.1" % "test",
                            "org.specs2" %% "specs2-scalacheck" % "4.4.1" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")