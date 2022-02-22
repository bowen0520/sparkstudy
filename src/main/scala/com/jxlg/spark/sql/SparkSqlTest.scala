package com.jxlg.spark.sql

import org.apache.spark.sql.{SQLContext, SparkSession}

object SparkSqlTest {
  case class Person(name:String,age:Int)

  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession
      .builder()
      .master("local[*]")
      .appName("SparkSqlTest")
      .getOrCreate()
    import sparkSession.implicits._

    val rddPerson = sparkSession.sparkContext.textFile("E:\\OneDrive\\person.txt")

    val dsPerson = rddPerson.map(v => {
      val strs = v.split("\\t")
      Person(strs(0), strs(1).trim.toInt)
    }).toDS()

    dsPerson.show()

    dsPerson.filter($"age">15).show()

    dsPerson.createOrReplaceTempView("person")

    sparkSession.sql("select * from person where age > 15").show()

    dsPerson.write.json("E:\\OneDrive\\person.json")

    sparkSession.close()
  }
}
