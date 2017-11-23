package com.github.sguzman.scala.scatter

import com.danielasfregola.twitter4s.entities.Tweet
import com.danielasfregola.twitter4s.entities.streaming.StreamingMessage
import com.github.sguzman.scala.scatter.jcommander.Args
import com.github.sguzman.scala.scatter.twitter.Get

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Main {
  val tweets: ListBuffer[Tweet] = mutable.ListBuffer[Tweet]()
  def main(args: Array[String]): Unit = {
    val argv = Args(args)
    val rest = twitter.Init.rest(argv)
    val status = Get.timeline(rest)
    val tweets = Get.extract(status.data)

    def printTweetText: PartialFunction[StreamingMessage, Unit] = {
      case tweet: Tweet => println(tweet.text)
    }

    val stream = twitter.Init.stream(argv)
    stream.filterStatuses(follow = Seq(22822722))(printTweetText)

    tweets foreach println
  }

  def printTweetText: PartialFunction[StreamingMessage, Unit] = {
    case tweet: Tweet => println(tweet.text)
  }
}
