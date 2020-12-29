resolvers += Resolver.bintrayIvyRepo("hmrc", "sbt-plugin-releases")
resolvers += Resolver.bintrayRepo("hmrc", "releases")

addSbtPlugin("de.heikoseeberger" % "sbt-header"         % "4.1.0")
addSbtPlugin("uk.gov.hmrc"       % "sbt-artifactory"    % "1.0.0")
addSbtPlugin("uk.gov.hmrc"       % "sbt-git-versioning" % "2.1.0")
addSbtPlugin("uk.gov.hmrc"       % "sbt-settings"       % "4.7.0")
