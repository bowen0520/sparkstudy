package com.jxlg.spark.sql

import org.apache.spark.{SparkConf, SparkContext}

object SortTest {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("SortTest")
      .setMaster("local[*]")
    val sc = new SparkContext(sparkConf)

    
    var n = 0
    val lines = sc.textFile("src/main/resources/")
    val numbers = lines.filter(_.trim.length>0).map(num => (num.trim.toInt,0)).repartition(1)
    val sortNumber = numbers.sortByKey().map(v => {n+=1;(n,v._1)})

    sortNumber.saveAsTextFile("E:\\OneDrive\\sort")

    sc.stop()
  }
}
