package com.roblayton.example

import akka.actor.Actor

class PongActor extends Actor {
  def receive = {
    case PingMsg =>
      println("   Pong")
      sender ! PongMsg
    case StopMsg =>
      println("   Pong stopped")
      context.stop(self)
  }
}
