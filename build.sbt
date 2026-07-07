name := "coding-interview-questions"

version := "2.0.0"

scalaVersion := "3.3.8"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "4.23.0" % Test,
  "org.specs2" %% "specs2-scalacheck" % "4.20.8" % Test,
  "org.scalacheck" %% "scalacheck" % "1.19.0" % Test
)

// Modern Scala 3 compiler options
scalacOptions ++= Seq(
  "-encoding", "utf8",
  "-deprecation",
  "-unchecked",
  "-feature",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-Wunused:all",
  "-Wvalue-discard",
  "-Xfatal-warnings"
)

Test / scalacOptions ++= Seq(
  "-Wconf:msg=unused:s"  // Suppress unused warnings in tests
)