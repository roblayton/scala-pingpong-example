package com.roblayton.example

import akka.actor.Actor
import akka.actor.ActorRef

class PingActor(count: Int, pong: ActorRef) extends Actor {
  var remaining = count
  def process { remaining -= 1; println("Ping: " + remaining) }
  def receive = {
    case StartMsg =>
      process
      pong ! PingMsg
    case PongMsg =>
      process
      if (remaining < 0) {
        sender ! StopMsg
        println("Ping stopped")
        context.stop(self)
      } else {
        sender ! PingMsg
      }
  }
}
