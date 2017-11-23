package com.github.sguzman.scala.scatter.twitter

import com.danielasfregola.twitter4s.TwitterRestClient
import com.danielasfregola.twitter4s.entities.{AccessToken, ConsumerToken}
import com.github.sguzman.scala.scatter.jcommander.Args

object Init {
  def apply(consumerKey: String,
             consumerSecret: String,
             accessToken: String,
             accessSecret: String): TwitterRestClient = {
    val consumer = ConsumerToken(consumerKey, consumerSecret)
    val access = AccessToken(accessToken, accessSecret)
    val client = TwitterRestClient(consumer, access)

    client
  }

  def apply(args: Args) =
    apply(args.consumerKey, args.consumerSecret, args.accessToken, args.accessTokenSecret)
}
