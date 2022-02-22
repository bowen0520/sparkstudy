package com.jxlg.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamingTest {
  def main(args: Array[String]): Unit = {
    StreamingExamples.setStreamingLogLevels()

    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("StreamingTest")

    val streamContest = new StreamingContext(sparkConf,Seconds(20))

    val lines = streamContest.textFileStream("E:\\OneDrive\\data")

    val value1 = lines
      .flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _).foreachRDD(rdd=>{
      rdd.sortByKey(false,1).foreach(x=>{
        println(x._1+":"+x._2)
      })
    })
    streamContest.start()
    streamContest.awaitTermination()

  }
}
