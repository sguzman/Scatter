/** Name of project */
name := "Scatter"

/** Organization */
organization := "com.github.sguzman"

/** Project Version */
version := "1.0"

/** Scala version */
scalaVersion := "2.12.4"

/** Scalac parameters */
scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation", "-encoding", "utf8")

/** Javac parameters */
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

/** Resolver */
resolvers ++= Seq(
  DefaultMavenRepository,
  Resolver.sonatypeRepo("public"),
  Resolver.typesafeRepo("releases"),
  Resolver.sbtPluginRepo("releases"),
  Resolver.jcenterRepo
)

/** Source Dependencies */
libraryDependencies ++= Seq(
  "com.criteo.lolhttp" % "lolhttp_2.12" % "0.8.1",
  "com.beust" % "jcommander" % "1.72",
  "com.google.code.gson" % "gson" % "2.8.2",
  "com.danielasfregola" % "twitter4s_2.12" % "5.2",
  "org.slf4j" % "slf4j-api" % "1.7.25",
  "org.slf4j" % "slf4j-jdk14" % "1.7.25",
  "org.scalatest" % "scalatest_2.12" % "3.2.0-SNAP9" % "test"
)

/** Make sure to fork on run */
fork in run := true

herokuFatJar in Compile := Some((assemblyOutputPath in assembly).value)