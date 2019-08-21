package com.knoldus.premonrservice

import org.apache.spark.sql.{Dataset, SparkSession}
import org.scalatest.{BeforeAndAfterAll, FlatSpec}

class InputAdapterServiceSpec extends FlatSpec with BeforeAndAfterAll with InputAdapterService {

  val sparkSession: SparkSession = SparkSession
    .builder
    .appName(Constants.SparkAppName)
    .master(Constants.SparkMaster)
    .getOrCreate()

  override def afterAll(): Unit = {

    sparkSession.close()
    sparkSession.stop()

  }

  "consume" should "return Dataset" in {

    val actualResult: Dataset[(String, String)] = consume()
    assert(actualResult != null)

  }

}
