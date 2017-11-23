package com.github.sguzman.scala.scatter

import lol.http.{at, _}

import scala.concurrent.ExecutionContext.Implicits.global

object Main {
  def main(args: Array[String]): Unit = {
    Server.listen(8888) {
      case GET at url"/hello" =>
        Ok(s"Hello World")
      case GET at url"/hello/" =>
        Ok(s"Hello World")
      case GET at url"/hello/$id" =>
        Ok(s"Hello World: $id")
      case _ =>
        NotFound
    }
  }
}