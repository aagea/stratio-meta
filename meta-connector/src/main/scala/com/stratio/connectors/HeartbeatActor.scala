package com.stratio.connectors

import java.util.concurrent.{Executors, TimeUnit}

import akka.actor.Actor
import com.stratio.meta.communication.HeartbeatSig


trait HeartbeatActor extends Actor {

  private val scheduler = Executors.newSingleThreadScheduledExecutor()

  private val callback = new Runnable {
    def run = {
      println("heartbeat.")
      self ! new HeartbeatSig()
    }
  }

  scheduler.scheduleAtFixedRate(callback, 0, 500, TimeUnit.MILLISECONDS)

  def receive: Receive = {
    case heartbeat: HeartbeatSig => {
      handleHeartbeat(heartbeat)
    }
  }

  def handleHeartbeat(heartbeat: HeartbeatSig) = {
    println("HeartbeatActor receives a heartbeat message")
  }


}
