scalaVersion := "2.12.8"
resolvers ++= Seq(
  ivyResolver("bintray-sbt-plugin-releases", "http://dl.bintray.com/content/sbt/sbt-plugin-releases"),
  ivyResolver("malliina bintray sbt", "https://dl.bintray.com/malliina/sbt-plugins/")
)

Seq(
  "com.malliina" %% "sbt-utils-bintray" % "0.11.0"
) map addSbtPlugin

def ivyResolver(name: String, urlStr: String) =
  Resolver.url(name, url(urlStr))(Resolver.ivyStylePatterns)
