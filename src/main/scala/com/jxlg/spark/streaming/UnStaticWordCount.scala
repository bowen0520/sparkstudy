package com.jxlg.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object UnStaticWordCount {
  def main(args: Array[String]): Unit = {
    StreamingExamples.setStreamingLogLevels()

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("UnStaticWordCount")

    val streamingContext = new StreamingContext(sparkConf, Seconds(5))

    streamingContext.checkpoint("E:\\OneDrive\\checkpoint")

    val lines = streamingContext.textFileStream("file:///E:/OneDrive/word")

    val wordmap = lines
      .flatMap(_.split(" "))
      .map((_,1))


    wordmap.reduceByKeyAndWindow(_+_,_-_,Seconds(20),Seconds(5))
      .repartition(1)
      .saveAsTextFiles("E:\\OneDrive\\test")

    wordmap.updateStateByKey[Int]((seq,opt)=>{
      val newCount = seq.foldLeft(0)(_+_)
      val oldCount = opt.getOrElse(0)

      Some(newCount + oldCount)
    }).repartition(1)
      .saveAsTextFiles("E:\\OneDrive\\test")

    streamingContext.start()

    streamingContext.awaitTermination()
  }
}
