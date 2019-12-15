val p = Project("sbt-filetree", file("."))
  .enablePlugins(BintrayReleasePlugin)
  .settings(
    scalaVersion := "2.12.10",
    organization := "com.malliina",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % Test
  )
