package com.github.sguzman.scala.scatter

import com.github.sguzman.scala.scatter.jcommander.Args
import com.github.sguzman.scala.scatter.twitter.Get

object Main {
  def main(args: Array[String]): Unit = {
    val argv = Args(args)
    val client = twitter.Init(argv)
    val status = Get.timeline(client)
    println(status)

    /*Server.listen(8888) {
      case GET at url"/tweets" =>
        Ok("{}")
      case GET at url"/tweets/" =>
        Get(since = 0)
      case GET at url"/tweets/$id" =>
        if (id.forall(_.isDigit))
          Get(id.toInt)
        else
          NotFound
      case _ =>
        NotFound
    }*/
  }
}
