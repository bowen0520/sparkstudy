package com.jxlg.spark.streaming

import org.apache.log4j.Level
import org.apache.log4j.Logger


object StreamingExamples {
  def setStreamingLogLevels(): Unit ={
    val log4jInitialized = Logger.getRootLogger.getAllAppenders.hasMoreElements
    if(!log4jInitialized){
      Logger.getRootLogger.setLevel(Level.WARN)
    }
  }
}
