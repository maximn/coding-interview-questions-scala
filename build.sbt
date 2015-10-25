name := "coding-interview-questions"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.6.5" % "test",
                            "com.twitter" %% "util-collection" % "6.27.0")

scalacOptions in Test ++= Seq("-Yrangepos")