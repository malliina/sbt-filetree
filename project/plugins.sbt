scalaVersion := "2.12.10"

Seq(
  "com.malliina" %% "sbt-utils-maven" % "0.15.7",
  "ch.epfl.scala" % "sbt-bloop" % "1.4.0-RC1",
  "org.scalameta" % "sbt-scalafmt" % "2.3.0"
) map addSbtPlugin
