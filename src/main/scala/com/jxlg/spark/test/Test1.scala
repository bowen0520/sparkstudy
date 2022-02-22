package com.jxlg.spark.test

object Test1 {



  def getSum(q:Double):Double = {
    var n = 1.0

    var sum = (n+1)/n

    while(sum<q){
      n += 1
      sum += (n+1)/n
    }

    sum
  }

  def main(args: Array[String]): Unit = {
    val sn1 = getSum(1.0)
    val sn2 = getSum(30.0)
    val sn3 = getSum(50.0)

    printf("Sn = %.3f",sn1)
    println()
    printf("Sn = %.3f",sn2)
    println()
    printf("Sn = %.3f",sn3)
    println()
  }
}
