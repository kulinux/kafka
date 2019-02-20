import sbt._




object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
  lazy val kafkaClient = "net.cakesolutions" %% "scala-kafka-client" % "2.1.0"
  lazy val kafkaClientAkka = "net.cakesolutions" %% "scala-kafka-client-akka" % "2.1.0"
}
