package com.knoldus.premonrservice.utill

package com.knoldus.premonrservice

object ConstantsOutput {

  val SparkAppName: String = "OutputAdapter"
  val FilePath: String ="output-adapter/file/example.json"
  val SparkMaster: String = "local[1]"
  val SparkInputSource: String = "kafka"
  val SparkKafkaServerKey: String = "kafka.bootstrap.servers"
  val SparkKafkaServerValue: String = "localhost:9092"
  val SparkKafkaTopicKey: String = "subscribe"
  val SparkKafkaTopicValue: String = "cake"
  val CastToStringValue = "CAST(value AS STRING)"
  val CastToStringKey = "CAST(key AS STRING)"
  val OutputMode = "update"
  val OutputFormat = "console"

}
