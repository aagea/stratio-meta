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

package com.stratio.meta2.server.actors

import akka.actor.{Actor, ActorRef, Props}
import com.stratio.meta.common.result.{QueryStatus, Result}
import com.stratio.meta.communication.ACK
import com.stratio.meta2.core.planner.Planner
import com.stratio.meta2.core.query.{SelectValidatedQuery, MetadataValidatedQuery}
import org.apache.log4j.Logger

object PlannerActor {
  def props(executor: ActorRef, planner: Planner): Props = Props(new PlannerActor(executor, planner))
}

class PlannerActor(coordinator: ActorRef, planner: Planner) extends Actor with TimeTracker {
  override lazy val timerName = this.getClass.getName
  val log = Logger.getLogger(classOf[PlannerActor])

  def receive = {
    //case query: ValidatedQuery => {
    case query: MetadataValidatedQuery => {
      println("\n\n\ngetting MetadataValidatedQuery; sending ack to "+sender+"\n\n\n")
      val timer = initTimer()
      //val planned = planner.planQuery(query)
      finishTimer(timer)
      //coordinator forward planned
      //TODO plan metadata queries

      val ack = ACK(query.getQueryId, QueryStatus.PLANNED)
      sender ! ack
    }
    case query: SelectValidatedQuery => {
      println("\n\n\ngetting SelectValidatedQuery; sending ack to "+sender+"\n\n\n")
      val timer = initTimer()
      val planned = planner.planQuery(query)
      finishTimer(timer)
      coordinator forward planned

      val ack = ACK(query.getQueryId, QueryStatus.PLANNED)
      sender ! ack
    }

    case _ => {
      sender ! Result.createUnsupportedOperationErrorResult("Not recognized object")
    }
  }

}
