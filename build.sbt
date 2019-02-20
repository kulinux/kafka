import Dependencies._


resolvers += Resolver.bintrayRepo("cakesolutions", "maven")


ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.pako"
ThisBuild / organizationName := "kafka"


lazy val root = (project in file("."))
  .settings(
    name := "kafka",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      kafkaClient,
      kafkaClientAkka,
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
