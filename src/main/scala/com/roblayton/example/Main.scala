package com.roblayton.example

import akka.actor.ActorSystem
import akka.actor.Props

/**
 * @author hire@roblayton.com
 *
 * Modified Example from the Scala Cookbook
 * http://shop.oreilly.com/product/0636920026914.do
 *
 */

object Main extends App {
  var system = ActorSystem("PingPongSystem")
  val pong = system.actorOf(Props[PongActor], name="pong")
  var ping = system.actorOf(Props(new PingActor(20, pong)), name = "ping")
  ping ! StartMsg
}
