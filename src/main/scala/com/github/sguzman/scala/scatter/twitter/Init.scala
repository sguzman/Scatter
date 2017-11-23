package com.github.sguzman.scala.scatter.twitter

import com.danielasfregola.twitter4s.{TwitterRestClient, TwitterStreamingClient}
import com.danielasfregola.twitter4s.entities.{AccessToken, ConsumerToken}
import com.github.sguzman.scala.scatter.jcommander.Args

object Init {
  def rest(consumerKey: String,
             consumerSecret: String,
             accessToken: String,
             accessSecret: String): TwitterRestClient = {
    val consumer = ConsumerToken(consumerKey, consumerSecret)
    val access = AccessToken(accessToken, accessSecret)
    val client = TwitterRestClient(consumer, access)

    client
  }

  def rest(args: Args): TwitterRestClient =
    rest(args.consumerKey, args.consumerSecret, args.accessToken, args.accessTokenSecret)

  def stream(consumerKey: String,
           consumerSecret: String,
           accessToken: String,
           accessSecret: String): TwitterStreamingClient = {
    val consumer = ConsumerToken(consumerKey, consumerSecret)
    val access = AccessToken(accessToken, accessSecret)
    val client = TwitterStreamingClient(consumer, access)

    client
  }

  def stream(args: Args): TwitterStreamingClient =
    stream(args.consumerKey, args.consumerSecret, args.accessToken, args.accessTokenSecret)
}
