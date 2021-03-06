//package com.kkb.spark.batch.test
//
//import org.apache.log4j.{Level, Logger}
//import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}
//import org.apache.spark.{SparkConf, SparkContext}
//
//object Hdfs2HdfsByPartition {
//
//  Logger.getLogger("org").setLevel(Level.WARN)
//  private val logger = Logger.getLogger(this.getClass)
//
//  def main(args: Array[String]): Unit = {
//
//    if (args.length < 3) {
//      System.err.println("Usage: args参数不正确 [2]-defaultFS [1]-userName [3]-sourcehdfsPathPre [4]-targethdfsPath")
//      System.exit(1)
//    }
//
//    val userName = args(0)
//    val defaultFS = args(1)
//    val sourceHdfsPath = args(2)
//    val targetHdfsPath = args(3)
//
//    println(s"~~~~~~~ userName : $userName ~~~~~~")
//    println(s"~~~~~~~ defaultFS : $defaultFS ~~~~~~")
//    println(s"~~~~~~~ sourceHdfsPath : $sourceHdfsPath ~~~~~~")
//    println(s"~~~~~~~ targetHdfsPath : $targetHdfsPath ~~~~~~")
//
//    System.setProperty("HADOOP_USER_NAME", userName)
//    val sc =initSparkContext()
//    val spark = SparkSessionSingleton.getInstance(sc.getConf)
//
//    val fileList = GetHDFSAllFileName.getFilepath(defaultFS,sourceHdfsPath)
//    val frame: DataFrame = spark.read.orc("")
//    for (file <- fileList) {
////      println(file.getParent.toString)
//      val sourceDF = spark.read.orc(file.getParent.toString)
//      val name = file.getParent.getName
//      val str: String = targetHdfsPath + "/" + name
////      println(str)
//      sourceDF.write.mode(SaveMode.Overwrite).parquet(str)
//    }
//
////    val sourceDF = spark.read.orc(sourceHdfsPath)
////    sourceDF.printSchema()
////    sourceDF.write.mode(SaveMode.Overwrite).parquet(targetHdfsPath)
////    val targetDF = spark.read.parquet(targetHdfsPath)
////    targetDF.printSchema()
//
//    //    val resultDF = spark.sqlContext.sql("select * from vdm_hrms.v_o_teaching_record limit 2")
//    //    resultDF.show(5)
//    //    resultDF.write.mode(SaveMode.Overwrite).format("parquet").save(hdfsPath)
//
//
//    //    sql("select * from vdm_hrms.v_o_teaching_record limit 2").show(10)
//
//    println(s"~~~~~~~ write $sourceHdfsPath to $targetHdfsPath success ~~~~~~")
//
//    spark.stop()
//
//  }
//
//
//
//
//  object SparkSessionSingleton {
//
//    @transient private var instance: SparkSession = _
//    def getInstance(sparkConf: SparkConf): SparkSession = {
//      if (instance == null) {
//        instance = SparkSession
//          .builder
//          .config(sparkConf)
//          //          .config("spark.sql.warehouse.dir", "hdfs://10.121.18.6:8020/user/hive/warehouse")
//          //          .config("hive.metastore.uris","thrift://10.121.18.8:9083,thrift://10.121.18.9:9083")
//          .enableHiveSupport()
//          .getOrCreate()
//      }
//      instance
//    }
//  }
//
//  /** init SparkContext */
//  def initSparkContext() = {
//    val conf = new SparkConf()
////        conf.set("spark.master","local[*]")
//    conf.set("spark.app.name", "HDFSToHDFS")
//    //    conf.set("spark.sql.sources.default","orc")
//    conf.set("spark.master", "yarn")
//    val sc = new SparkContext(conf)
//    sc
//  }
//
//
//}
