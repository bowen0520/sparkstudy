package com.jxlg.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object CoreTest {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("CoreTest")

    val sc = new SparkContext(sparkConf)

    sc.makeRDD(Array(1,2,3)).cache()
  }
}
