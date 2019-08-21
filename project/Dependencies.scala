import sbt._

object Dependencies {

  val scala = "2.12.8"
  val logbackClassicVersion = "1.2.3"
  val scalaTestVersion = "3.0.5"
  val sparkVersion = "2.4.3"

  val logback = "ch.qos.logback" % "logback-classic" % logbackClassicVersion
  val config = "com.typesafe" % "config" % "1.2.1"
  val liftJson = "net.liftweb" %% "lift-json" % "3.3.0"
  val sparkCore = "org.apache.spark" %% "spark-core" % sparkVersion
  val sparkSql = "org.apache.spark" %% "spark-sql" % sparkVersion
  val sparkStreaming = "org.apache.spark" %% "spark-streaming" % sparkVersion
  val sparkSqlKafka = "org.apache.spark" %% "spark-sql-kafka-0-10" % sparkVersion

  /** Test libraries */
  val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion
  val mock = "org.mockito" % "mockito-core" % "2.27.0"

  val commonDependencies = Seq(scalaTest, mock, liftJson)

  val inputAdapterDependencies = Seq(logback, config, sparkSqlKafka, sparkCore, sparkStreaming, sparkSql)

  val preMonRServiceDependencies = Seq(logback, config, sparkCore,
    sparkSql, sparkStreaming)

  val outputAdapterDependencies = Seq(logback, config, sparkCore, sparkSql)

}

