package consumer

import cakesolutions.kafka.KafkaConsumer
import cakesolutions.kafka.KafkaConsumer.Conf
import com.typesafe.config.ConfigFactory
import org.apache.kafka.common.serialization.StringDeserializer
import scala.collection.JavaConverters._
import scala.concurrent.duration._

import scala.util.{Failure, Success}

object Consumer extends App {

  val conf = ConfigFactory.load

  val consumer = KafkaConsumer(
    Conf(conf, new StringDeserializer(), new StringDeserializer())
  )

  consumer.subscribe(Seq("topic").asJava)

  while (true) {
    val cons = consumer.poll(java.time.Duration.ofSeconds(2))
    println("One " + cons + " count " + cons.count())

    cons.forEach( c => println(c) )
    Thread.sleep(100)
  }




  Thread.sleep(100000)


}
