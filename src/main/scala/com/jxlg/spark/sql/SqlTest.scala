package com.jxlg.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SqlTest {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder()
      .appName("SQL")
      .master("local[*]")
      .getOrCreate()

    import sparkSession.implicits._

    val frame = sparkSession.read.csv("E:\\OneDrive\\chapter5-data1.txt")
  }
}
