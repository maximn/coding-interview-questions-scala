logLevel := Level.Warn

resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.+")

addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.+")
