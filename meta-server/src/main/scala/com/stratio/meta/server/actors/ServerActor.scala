/*
* Licensed to STRATIO (C) under one or more contributor license agreements.
* See the NOTICE file distributed with this work for additional information
  * regarding copyright ownership.  The STRATIO (C) licenses this file
  * to you under the Apache License, Version 2.0 (the
  * "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
  * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
  * KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package com.stratio.meta.server.actors

import java.util.UUID

import akka.actor.{Actor, Props, ReceiveTimeout}
import akka.cluster.Cluster
import akka.cluster.ClusterEvent._
import com.stratio.meta.common.ask.{Command, Connect, Query}
import com.stratio.meta.common.result._
import com.stratio.meta.communication.Disconnect
import com.stratio.meta.core.engine.Engine
import org.apache.log4j.Logger

object ServerActor{
  def props(engine: Engine): Props = Props(new ServerActor(engine))
}

class ServerActor(engine:Engine) extends Actor {
  val log =Logger.getLogger(classOf[ServerActor])
  val connectorActorRef=context.actorOf(ConnectorActor.props(),"ConnectorActor")
  val queryActorRef= context.actorOf(QueryActor.props(engine,connectorActorRef),"QueryActor")
  val cmdActorRef= context.actorOf(APIActor.props(engine.getAPIManager),"APIActor")


  override def preStart(): Unit = {
    //#subscribe
    Cluster(context.system).subscribe(self, classOf[MemberEvent])
    //cluster.subscribe(self, initialStateMode = InitialStateAsEvents, classOf[MemberEvent], classOf[UnreachableMember])
  }
  override def postStop(): Unit =
    Cluster(context.system).unsubscribe(self)

  def receive = {
    case query:Query =>
      //println("query: " + query)
      queryActorRef forward query
    case Connect(user)=> {
      log.info("Welcome " + user +"!")
      //println("Welcome " + user +"!")
      sender ! ConnectResult.createConnectResult(UUID.randomUUID().toString)
    }
    case Disconnect(user)=> {
      log.info("Goodbye " + user +".")
      //println("Welcome " + user +"!")
      sender ! DisconnectResult.createDisconnectResult(user)
    }
    case cmd: Command => {
      log.info("API Command call " + cmd.commandType)
      cmdActorRef forward cmd
    }
    //pass the message to the connectorActor to extract the member in the cluster
    case member: MemberUp => {
      //println("Member is Up: " + member.toString + member.getRoles.toString())
      connectorActorRef ! member
      //val memberActorRef = context.actorSelection(RootActorPath(member.address) / "user" / "clusterListener")
      // connectorsMap += (member.toString -> memberActorRef)
      //memberActorRef ! "hola pichi, estás metaregistrado"
    }
    case state: CurrentClusterState => {
      //log.info("Current members: {}"+ state.members.mkString(", "))
      connectorActorRef ! state
    }

    //    case UnreachableMember(member) => {
    case member: UnreachableMember => {

      //log.info("Member detected as unreachable: {}"+ member)
      connectorActorRef ! member
    }


    case member: MemberRemoved=>{
      //      log.info("Member is Removed: {} after {}",
      //        member.address, previousStatus)
      connectorActorRef ! member
    }

    case _: MemberEvent =>{
      log.info("Receiving anything else")


    }

    case _: ClusterDomainEvent =>{
      println("ClusterDomainEvent")
    }

    case ReceiveTimeout =>{
      println("ReceiveTimeout")
    }

    case other =>{
      println("connector actor receive event")
    }

    case _ => {
      println("Unknown!!!!");
      sender ! Result.createUnsupportedOperationErrorResult("Not recognized object")
    }
  }
}
