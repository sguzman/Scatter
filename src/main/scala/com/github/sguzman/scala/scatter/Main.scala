package com.github.sguzman.scala.scatter

import com.danielasfregola.twitter4s.entities.Tweet
import com.danielasfregola.twitter4s.entities.streaming.StreamingMessage
import com.github.sguzman.scala.scatter.jcommander.Args
import com.github.sguzman.scala.scatter.twitter.Get

import lol.http._
import scala.concurrent.ExecutionContext.Implicits.global

import scala.collection.mutable

object Main {
  val tweets = mutable.ArrayBuffer[Twit]()
  def main(_args: Array[String]): Unit = {
    val consumerKey = System.getenv("CONSUMER_KEY")
    val consumerSecret = System.getenv("CONSUMER_KEY_SECRET")

    val accessToken = System.getenv("ACCESS_TOKEN")
    val accessTokenSecret = System.getenv("ACCESS_TOKEN_SECRET")

    var port = 8888
    try {
      port = System.getenv("PORT").toInt
    } catch {
      case _: Throwable => {
        println("Failed to collect port... defaulting to 8888")
      }
    }

    val args = Array(
      "--consumerKey", consumerKey,
      "--consumerSecret", consumerSecret,
      "--accessToken", accessToken,
      "--accessTokenSecret", accessTokenSecret
    )

    val argv = Args(args)
    val rest = twitter.Init.rest(argv)
    val status = Get.timeline(rest)
    val twts = status.data.map(Get.extract)
    twts.foreach(t => tweets.append(t))

    val stream = twitter.Init.stream(argv)
    //stream.filterStatuses(follow = Seq(22822722))(printTweetText)

    tweets foreach println

    Server.listen(port) {
      case GET at "/" =>
        Get.sendJson(tweets.toArray, since_id = 0)
      case GET at url"/$id" =>
        val idInt = if (id.toString.forall(_.isDigit)) id.toInt
        else 0
        Get.sendJson(tweets.toArray, idInt)
      case _ =>
        NotFound
    }
  }

  def printTweetText: PartialFunction[StreamingMessage, Unit] = {
    case tweet: Tweet =>
      val twit = Get.extract(tweet)
      println(s"New tweet: $twit")
      tweets.append(Get.extract(tweet))
  }
}
