package com.github.sguzman.scala.scatter.jcommander

import com.beust.jcommander.Parameter

class Args {
  @Parameter(
    names = Array("-k", "--consumerKey"),
    description = "Consumer key",
    arity = 1,
    help = false,
    echoInput = false,
    password = true,
    hidden = false,
    order = 1,
    required = true,
  )
  var consumerKey: String = ""

  @Parameter(
    names = Array("-s", "--consumerSecret"),
    description = "Consumer secret",
    arity = 1,
    help = false,
    echoInput = false,
    password = true,
    hidden = false,
    order = 2,
    required = true,
  )
  var consumerSecret: String = ""

  @Parameter(
    names = Array("-a", "--accessToken"),
    description = "Access token",
    arity = 1,
    help = false,
    echoInput = false,
    password = true,
    hidden = false,
    order = 3,
    required = true,
  )
  var accessToken: String = ""

  @Parameter(
    names = Array("-t", "--accessTokenSecret"),
    description = "Access token",
    arity = 1,
    help = false,
    echoInput = false,
    password = true,
    hidden = false,
    order = 4,
    required = true,
  )
  var accessTokenSecret: String = ""

  @Parameter(
    names = Array("-h", "--help"),
    description = "Help menu",
    arity = 0,
    help = true,
    echoInput = true,
    password = false,
    hidden = false,
    order = 5,
    required = false,
  )
  var help: Boolean = false
}
