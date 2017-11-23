package com.github.sguzman.scala.scatter.util

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

object Future {
  def apply[A](status: Future[A]): A = Await.result(status, Int.MaxValue.millis)
}
