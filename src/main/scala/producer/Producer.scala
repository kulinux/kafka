package producer

import cakesolutions.kafka.{KafkaProducer, KafkaProducerRecord}
import cakesolutions.kafka.KafkaProducer.Conf
import com.typesafe.config.ConfigFactory
import org.apache.kafka.common.serialization.StringSerializer
import scala.concurrent.ExecutionContext.Implicits._

import scala.util.{Failure, Success}

object Producer extends App {

  val conf = ConfigFactory.load

  val producer = KafkaProducer(
    Conf(conf, new StringSerializer(), new StringSerializer())
  )

  while(true) {
    val record = KafkaProducerRecord("topic", Some("key"), "Value")
    val res = producer.send(record)

    res.onComplete({
      case Success(md)  => println(md)
      case Failure(excp)  => {
        excp.printStackTrace()
        println(excp)
      }
    })
    Thread.sleep(100)
  }

  Thread.sleep(100000)


}
