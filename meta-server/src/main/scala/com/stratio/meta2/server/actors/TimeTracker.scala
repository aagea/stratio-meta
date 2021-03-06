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

import com.codahale.metrics.Timer
import com.stratio.meta.common.utils.Metrics

/**
 * Trait to be able to time the operations inside an actor.
 */
trait TimeTracker {

  /**
   * Name of the timer.
   */
  lazy val timerName: String = ???

  /**
   * Timer gauge.
   */
  lazy val timerMetrics: Timer = Metrics.getRegistry.timer(timerName)

  /**
   * Initialize the timer.
   */
  def initTimer(): Timer.Context = timerMetrics.time()

  /**
   * Stop the timer.
   * @param context The timing context.
   * @return Whether it has stop.
   */
  def finishTimer(context: Timer.Context) = {
    context.stop()
  }
}
