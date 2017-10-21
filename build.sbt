import com.malliina.sbtutils.SbtProjects

lazy val p = SbtProjects.sbtPlugin("sbt-filetree")

organization := "com.malliina"

Seq(
  "com.jsuereth" % "sbt-pgp" % "1.1.0",
  "org.xerial.sbt" % "sbt-sonatype" % "2.0",
  "com.github.gseitz" % "sbt-release" % "1.0.6",
  "org.foundweekends" % "sbt-bintray" % "0.5.1"
) map addSbtPlugin
