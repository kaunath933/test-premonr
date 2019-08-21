package com.knoldus.premonrservice

import com.knoldus.premonrservice.utill.com.knoldus.premonrservice.ConstantsOutput
import org.apache.spark.sql.{DataFrame, SparkSession}

object OutputModel extends App {

  val sparkSession: SparkSession = SparkSession
    .builder()
    .appName(ConstantsOutput.SparkAppName)
    .master(ConstantsOutput.SparkMaster)
    .getOrCreate()

  val df: DataFrame = sparkSession.read.json(ConstantsOutput.FilePath)

  df.printSchema()
  df.show()

}
