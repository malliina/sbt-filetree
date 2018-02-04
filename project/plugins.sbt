scalaVersion := "2.12.4"
resolvers ++= Seq(
  ivyResolver("bintray-sbt-plugin-releases", "http://dl.bintray.com/content/sbt/sbt-plugin-releases"),
  ivyResolver("malliina bintray sbt", "https://dl.bintray.com/malliina/sbt-plugins/")
)

Seq(
  "com.malliina" %% "sbt-utils" % "0.7.0",
  "com.jsuereth" % "sbt-pgp" % "1.1.0",
  "org.xerial.sbt" % "sbt-sonatype" % "2.0",
  "com.github.gseitz" % "sbt-release" % "1.0.7",
  "org.foundweekends" % "sbt-bintray" % "0.5.1"
) map addSbtPlugin

def ivyResolver(name: String, urlStr: String) =
  Resolver.url(name, url(urlStr))(Resolver.ivyStylePatterns)
