lazy val p = Project("sbt-filetree", file("."))
  .enablePlugins(BintrayReleasePlugin)

organization := "com.malliina"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test
