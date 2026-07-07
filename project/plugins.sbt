logLevel := Level.Warn

resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "2.2.2")

addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.3.15")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.6.1")

addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.12.0")