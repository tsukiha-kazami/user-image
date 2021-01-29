package homework

import java.util.Properties
import java.util.regex.Pattern

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.kafka010.{CanCommitOffsets, ConsumerStrategies, ConsumerStrategy, HasOffsetRanges, KafkaUtils, LocationStrategies, OffsetRange}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author Shi Lei
 * @create 2021-01-26
 */
object homework03_2 {

  def main(args: Array[String]): Unit = {

    val brokers = "192.168.52.100:9092,192.168.52.110:9092,192.168.52.120:9092"
    val topics = Set("maxwell")
    val conf = new SparkConf().setMaster("local[4]").setAppName("homework03_2")
    val group_id: String = "homework03_2"
    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> brokers,
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> group_id,
      "auto.offset.reset" -> "latest", // earliest,latest,和none
      "enable.auto.commit" -> (true: java.lang.Boolean)
    )

    val sparkSession: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    val context: SparkContext = sparkSession.sparkContext
    context.setLogLevel("warn")

    //获取streamingContext
    val ssc = new StreamingContext(context, Seconds(3))
    val consumerStrategy: ConsumerStrategy[String, String] =  ConsumerStrategies.Subscribe[String,String](topics,kafkaParams)
    val dstreamFromKafka: InputDStream[ConsumerRecord[String, String]] = KafkaUtils
      .createDirectStream(ssc,LocationStrategies.PreferConsistent,consumerStrategy)

    dstreamFromKafka.foreachRDD(rdd =>{
//      获取消息内容
      //打印
      rdd.foreach(x=>{
        val topic: String = x.topic()
        val content: String = x.value()
        println(topic+" receive "+content)
        })

      //4、提交偏移量信息，把偏移量信息添加到kafka中
      val offsetRanges: Array[OffsetRange] =
        rdd.asInstanceOf[HasOffsetRanges].offsetRanges
      dstreamFromKafka.asInstanceOf[CanCommitOffsets].commitAsync(offsetRanges)
    })
  ssc.start()
  ssc.awaitTermination()
  }

}
