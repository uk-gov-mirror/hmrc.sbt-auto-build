import java.time.LocalDate

import uk.gov.hmrc.DefaultBuildSettings.{defaultSettings, scalaSettings, targetJvm}
import uk.gov.hmrc.SbtBuildInfo

val pluginName = "sbt-auto-build"

lazy val project = Project(pluginName, file("."))
  .enablePlugins(AutomateHeaderPlugin, SbtGitVersioning, SbtArtifactory)
  .settings(
    scalaSettings ++
      SbtBuildInfo() ++
      defaultSettings() ++
      headerSettings ++
      publishSettings ++
      artefactDescription: _*
  )
  .settings(
    sbtPlugin := true,
    majorVersion := 2,
    makePublicallyAvailableOnBintray := true,
    scalaVersion := "2.10.7",
    crossSbtVersions := Vector("0.13.18", "1.3.4"),
    targetJvm := "jvm-1.7",
    addSbtPlugin("com.typesafe.sbt" % "sbt-twirl" % "1.5.0"),
    addSbtPlugin("de.heikoseeberger" % "sbt-header" % "3.0.2"),
    addSbtPlugin("uk.gov.hmrc" % "sbt-settings" % "3.12.0-SNAPSHOT"),
    libraryDependencies ++= Seq(
      "org.eclipse.jgit" % "org.eclipse.jgit.pgm" % "3.7.1.201504261725-r",
      "org.scalatest"         %% "scalatest"    % "3.1.0-M2"  % Test,
      "com.vladsch.flexmark"  % "flexmark-all"  % "0.35.10"   % Test
    ),
    resolvers := Seq(
      Resolver.url("hmrc-sbt-plugin-releases", url("https://dl.bintray.com/hmrc/sbt-plugin-releases"))(Resolver.ivyStylePatterns)
    ),
    buildInfoOptions := Seq.empty
  )

val publishSettings = Seq(
    publishArtifact := true,
    publishArtifact in Test := false,
    publishArtifact in(Test, packageDoc) := false,
    publishArtifact in(Test, packageSrc) := false
  )

val headerSettings = {
  Seq(
    headerLicense := Some(HeaderLicense.ALv2(LocalDate.now().getYear.toString, "HM Revenue & Customs"))
  )
}

val artefactDescription =
    pomExtra := <url>https://www.gov.uk/government/organisations/hm-revenue-customs</url>
      <licenses>
        <license>
          <name>Apache 2</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        </license>
      </licenses>
      <scm>
        <connection>scm:git@github.com:hmrc/sbt-auto-build.git</connection>
        <developerConnection>scm:git@github.com:hmrc/sbt-auto-build.git</developerConnection>
        <url>git@github.com:hmrc/sbt-auto-build.git</url>
      </scm>
      <developers>
        <developer>
          <id>charleskubicek</id>
          <name>Charles Kubicek</name>
          <url>http://www.equalexperts.com</url>
        </developer>
        <developer>
          <id>duncancrawford</id>
          <name>Duncan Crawford</name>
          <url>http://www.equalexperts.com</url>
        </developer>
      </developers>
