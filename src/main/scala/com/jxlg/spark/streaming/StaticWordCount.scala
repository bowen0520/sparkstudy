package com.jxlg.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StaticWordCount {
  def main(args: Array[String]): Unit = {
    StreamingExamples.setStreamingLogLevels()
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("StaticWordCount")
    val streamingContext = new StreamingContext(sparkConf,Seconds(20))

    streamingContext.checkpoint("E:\\OneDrive\\checkpoint")

    val lines = streamingContext.textFileStream("file:///E:/OneDrive/word")   //textFileStream("E:\\OneDrive\\test.txt")

    lines.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).repartition(1).saveAsTextFiles("E:\\OneDrive\\test")

    streamingContext.start()

    streamingContext.awaitTermination()
  }
}
