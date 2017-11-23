package com.github.sguzman.scala.scatter.twitter

import lol.http.Ok

object Get {
  def apply(since: Int) = {
    Ok(s"""{"since": $since}" """)
  }
}
