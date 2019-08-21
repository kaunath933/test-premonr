package com.knoldus.premonrservice

import org.apache.spark.sql.{Dataset, SparkSession}

trait InputAdapterService {

  val sparkSession: SparkSession

  import sparkSession.implicits._

  def consume(): Dataset[(String, String)] = sparkSession
    .readStream
    .format(Constants.SparkInputSource)
    .option(Constants.SparkKafkaServerKey, Constants.SparkKafkaServerValue)
    .option(Constants.SparkKafkaTopicKey, Constants.SparkKafkaTopicValue)
    .load().selectExpr(Constants.CastToStringKey, Constants.CastToStringValue).as[(String, String)]

}

object InputAdapterService extends InputAdapterService {

  val sparkSession: SparkSession = SparkSession
    .builder
    .appName(Constants.SparkAppName)
    .master(Constants.SparkMaster)
    .getOrCreate()

}
