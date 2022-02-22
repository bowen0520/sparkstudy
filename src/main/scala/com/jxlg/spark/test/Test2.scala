package com.jxlg.spark.test

object Test2 {
  def main(args: Array[String]): Unit = {
    val p = Point(10,30)
    p.draw()
    val line1 = new Line(Point(0,0),Point(20,20))
    line1.draw()
    line1.moveTo(Point(5,5))
    line1.draw()
    line1.zoom(2)
    line1.draw()
    val cir = new Circle(Point(10,10),5)
    cir.draw()
    cir.moveTo(Point(30,20))
    cir.draw()
    cir.zoom(0.5)
    cir.draw()
  }
}

trait Drawable{
  def draw(): Unit ={
    this.toString
  }
}

case class Point(var x:Double,var y:Double) extends Drawable{
  def shift(deltaX:Double,deltaY:Double): Unit ={
    x += deltaX
    y += deltaY
  }

  override def draw(): Unit = {
    printf("Point(%.1f,%.1f)",x,y)
    println()
  }
}

abstract class Shape(val point:Point){
  def moveTo(newPoint:Point): Unit ={
    point.x = newPoint.x
    point.y = newPoint.y
  }

  def zoom(n:Double)
}

class Line(pointa: Point,pointb: Point) extends Shape(pointa) with Drawable{
  override def moveTo(newPoint: Point): Unit = {
    val diffx = pointa.x - newPoint.x
    val diffy = pointa.y - newPoint.y

    pointa.x = pointa.x - diffx
    pointa.y = pointa.y - diffy

    pointb.x = pointb.x - diffx
    pointb.y = pointb.y - diffy
  }

  override def zoom(n: Double): Unit = {
    val powx = (pointa.x - pointb.x)/2
    val powy = (pointa.y - pointb.y)/2

    val midx = (pointa.x + pointb.x)/2
    val midy = (pointa.y + pointb.y)/2

    pointa.x = midx + n*powx
    pointa.y = midy + n*powy

    pointb.x = midx - n*powx
    pointb.y = midy - n*powy
  }

  override def draw(): Unit = {
    printf("Line:(%.1f,%.1f)--(%.1f,%.1f)",pointa.x,pointa.y,pointb.x,pointb.y)
    println()
  }
}

class Circle(point: Point,var r:Double) extends Shape(point) with Drawable{
  override def moveTo(newPoint: Point): Unit = {
    point.x = newPoint.x
    point.y = newPoint.y
  }

  override def zoom(n: Double): Unit = {
    r = r*n
  }

  override def draw(): Unit = {
    printf("Circle center:(%.1f,%.1f),R=%.1f",point.x,point.y,r)
    println()
  }
}
