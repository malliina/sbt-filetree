val p = Project("sbt-filetree", file("."))
  .enablePlugins(MavenCentralPlugin)
  .settings(
    sbtPlugin := true,
    scalaVersion := "2.12.10",
    organization := "com.malliina",
    gitUserName := "malliina",
    developerName := "Michael Skogberg",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )

Global / onChangedBuildSource := ReloadOnSourceChanges
