package com.knoldus.premonrservice

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.Dataset

object PremonRImpl {

  def main(args: Array[String]): Unit = {

    Logger.getLogger ("org").setLevel(Level.OFF)

    val dataSet = InputAdapterService.consume()

    val aggregate = agrregation(dataSet)

    val transform = transformation(dataSet)

    storeTransformation(transform)

    storeAggregation(aggregate)

  }

  import InputAdapterService.sparkSession.implicits._

  private def agrregation(dataSet: Dataset[(String, String)]): Dataset[(String, Long)] = {

    dataSet
      .map { case (key, value) => value }
      .flatMap(value => value.split(" "))
      .filter(_.equalsIgnoreCase("error"))
      .groupByKey(_.toLowerCase)
      .count()

  }

  private def transformation(dataSet: Dataset[(String, String)]): Dataset[Int] = {

    dataSet
      .map { case (key, value) => value }
      .flatMap(value => value.split(" "))
      .map(_.toInt + 1)

  }

  def storeAggregation(result: Dataset[(String, Long)]): Unit = {

    result.writeStream
      .format(Constants.OutputFormat)
      .outputMode(Constants.OutputMode)
      .start()
      .awaitTermination()

  }

  def storeTransformation(result: Dataset[(Int)]): Unit = {

    result.writeStream
      .format(Constants.OutputFormat)
      .outputMode(Constants.OutputMode)
      .start()
      .awaitTermination()

  }

}
