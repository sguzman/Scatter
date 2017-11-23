package com.github.sguzman.scala.scatter

import com.github.sguzman.scala.scatter.jcommander.Args
import com.github.sguzman.scala.scatter.twitter.Get
import lol.http.at
import lol.http.Ok
import lol.http.GET
import lol.http.NotFound
import lol.http.Server
import lol.http._

import scala.concurrent.ExecutionContext.Implicits.global

object Main {
  def main(args: Array[String]): Unit = {
    val argv = Args(args)

    Server.listen(8888) {
      case GET at url"/tweets" =>
        Ok("{}")
      case GET at url"/tweets/" =>
        Get(since = 0)
      case GET at url"/tweets/$id" =>
        Get(id.toInt)
      case _ =>
        NotFound
    }
  }
}
