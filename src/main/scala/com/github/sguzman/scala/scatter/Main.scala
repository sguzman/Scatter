package com.github.sguzman.scala.scatter

import com.danielasfregola.twitter4s.entities.Tweet
import com.danielasfregola.twitter4s.entities.streaming.StreamingMessage
import com.github.sguzman.scala.scatter.jcommander.Args
import com.github.sguzman.scala.scatter.twitter.Get

import scala.collection.mutable

object Main {
  val tweets = mutable.ListBuffer[Tweet]()
  def main(args: Array[String]): Unit = {
    val argv = Args(args)
    val rest = twitter.Init.rest(argv)
    val status = Get.timeline(rest)
    val twts = status.data.map(Get.extract)
    twts.foreach(tweets :+ _)

    val stream = twitter.Init.stream(argv)
    stream.filterStatuses(follow = Seq(22822722))(printTweetText)

    tweets foreach println
  }

  def printTweetText: PartialFunction[StreamingMessage, Unit] = {
    case tweet: Tweet => tweets :+ Get.extract(tweet)
  }
}
