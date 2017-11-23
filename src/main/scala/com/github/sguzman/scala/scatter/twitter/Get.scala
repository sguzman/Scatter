package com.github.sguzman.scala.scatter.twitter

import com.danielasfregola.twitter4s.TwitterRestClient
import com.github.sguzman.scala.scatter.util.FutureAwait
import lol.http.Ok

object Get {
  def apply(since: Int) = {
    Ok(s"""{"since": $since}" """)
  }

  def timeline(client: TwitterRestClient) =
    FutureAwait(client.userTimelineForUser("SBCFireDispatch"))

  def timeline(client: TwitterRestClient, since_id: Long) =
    FutureAwait(client.userTimelineForUser("SBCFireDispatch", Some(since_id)))
}
