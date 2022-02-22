package com.jxlg.spark.accumulator

import java.time.format.DateTimeFormatter
import java.util.Date

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val text = sc.textFile("E:\\OneDrive\\words.txt")

    println(new Date().getTime)
    println("----------------------------------------")

    val ac = text.flatMap(_.split(" "))
      .map((_, 1))
      .foldByKey(0,1)(_ + _)
      .sortBy(_._2,false)

    println("----------------------------------------")
    println(new Date().getTime)
    println("----------------------------------------")

    val actwo = text.flatMap(_.split(" "))
      .map((_,1))
      .reduceByKey(_+_,1)
      .sortBy(_._2,true)

    println("----------------------------------------")
    println(new Date().getTime)
    println("----------------------------------------")

    ac.foreach(v => println(v._1+":"+v._2))
    println("----------------------------------------")
    actwo.foreach(v => println(v._1+":"+v._2))
    ac.saveAsTextFile("E:\\OneDrive\\wordsCount")
    actwo.saveAsTextFile("E:\\OneDrive\\wordsCountTwo")
    sc.stop()
  }
}

/*
1594199521019
----------------------------------------
----------------------------------------
1594199521094
----------------------------------------
----------------------------------------
1594199521113
----------------------------------------
 */
