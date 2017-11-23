package com.github.sguzman.scala.scatter

import lol.http._
import scala.concurrent.ExecutionContext.Implicits.global

object Main {
  def main(args: Array[String]): Unit = {
    Server.listen(8888) {
      case GET at "/hello" =>
        Ok("Hello World!")
      case _ =>
        NotFound
    }
  }
}
