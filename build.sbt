val p = Project("sbt-filetree", file("."))
  .enablePlugins(BintrayReleasePlugin)
  .settings(
    organization := "com.malliina",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % Test
  )
