package com.jxlg.spark.test

import org.apache.spark.util.{AccumulatorV2, LongAccumulator}
import org.apache.spark.{SparkConf, SparkContext}

object Test3 {
  def main(args: Array[String]): Unit = {
    val sparkCof = new SparkConf().setMaster("local[*]").setAppName("Test3")

    val sc = new SparkContext(sparkCof)

    val lines = sc.textFile("E:\\OneDrive\\chapter5-data1.txt").cache()

    val studentNum = lines.map(_.split(",")(0)).distinct().count()

    println("学生数"+studentNum)

    val projectNum = lines.map(_.split(",")(1)).distinct().count()

    println("学科数"+projectNum)

    val tomAvgGrade = lines.filter(_.contains("Tom")).map(v => {
      val strs = v.split(",")
      (strs(0), (strs(2).trim.toInt, 1))
    }).reduceByKey((v1, v2) => {
      val k = v1._1 + v2._1
      val v = v1._2 + v2._2
      (k, v)
    }).map(v => (v._1, v._2._1.toDouble / v._2._2)).collect().apply(0)

    println("Tom平均分" + tomAvgGrade)

    val selectCourseNum = lines.map(v => {
      (v.split(",")(0), 1)
    }).reduceByKey(_ + _).collect()

    println("每人选课数:" + selectCourseNum.toString)

    val dataBaseNum = lines.filter(_.contains("DataBase")).count()

    println("选DataBase课程人数：" + dataBaseNum)

    val projectAvgGrade = lines.map(v => {
      val strs = v.split(",")
      (strs(1), (strs(2).trim.toInt, 1))
    }).reduceByKey((v1, v2) => {
      val k = v1._1 + v2._1
      val v = v1._2 + v2._2
      (k, v)
    }).map(v => (v._1, v._2._1.toDouble / v._2._2)).collect()

    println("每门课程平均分" + projectAvgGrade)

    val longAccumulator = new LongAccumulator
    sc.register(longAccumulator)

    val sum = lines.map(v => {
      if (v.contains("DataBase")) {
        longAccumulator.add(1L)
      }
      v
    }).count()

    println("总行数：" + sum + "DataBase选课数：" + longAccumulator.value)

    sc.stop()
  }
}
