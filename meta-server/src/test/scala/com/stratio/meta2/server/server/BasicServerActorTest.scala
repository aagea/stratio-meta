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

package com.stratio.meta2.server.server

import akka.actor.Props
import com.stratio.meta.common.ask.{Connect, Query}
import com.stratio.meta.common.result._
import com.stratio.meta.server.config.{ActorReceiveUtils, BeforeAndAfterCassandra}
import com.stratio.meta.server.utilities._
import com.stratio.meta2.core.engine.Engine
import com.stratio.meta2.server.actors.ServerActor
import org.scalatest.FunSuiteLike
import org.testng.Assert._

import scala.concurrent.duration._

/**
 * Server Actor tests.
 */
class BasicServerActorTest extends ActorReceiveUtils with FunSuiteLike with BeforeAndAfterCassandra {

  lazy val serverRef = system.actorOf(Props(classOf[ServerActor], engine), "test")
  val engine: Engine = createEngine.create()

  override def beforeCassandraFinish() {
    shutdown(system)
  }

  override def beforeAll(): Unit = {
    super.beforeAll()
    dropKeyspaceIfExists("ks_demo")
  }

  override def afterAll() {
    super.afterAll()
    engine.shutdown()
  }

  def executeStatement(query: String, keyspace: String, shouldExecute: Boolean): Result = {
    val stmt = Query("basic-server", keyspace, query, "test_actor")

    serverRef ! stmt
    val result = receiveActorMessages(shouldExecute, false, !shouldExecute)

    if (shouldExecute) {
      assertFalse(result.hasError, "Statement execution failed for:\n" + stmt.toString
        + "\n error: " + getErrorMessage(result))
    } else {
      assertTrue(result.hasError, "Statement should report an error")
    }

    result
  }

  test("Unknown message") {
    within(5000 millis) {
      serverRef ! 1
      val result = expectMsgClass(classOf[ErrorResult])
      assertTrue(result.hasError, "Expecting error message")
    }
  }

  test("ServerActor Test connect without error") {
    within(5000 millis) {
      serverRef ! Connect("test-user")
      val result = expectMsgClass(classOf[ConnectResult])
      assertFalse(result.hasError, "Error not expected")
      assertNotEquals(result.asInstanceOf[ConnectResult].getSessionId, -1, "Expecting session id")
    }
  }

  test("Create KS") {
    within(5000 millis) {
      val query = "create KEYSPACE ks_demo WITH replication = {class: SimpleStrategy, replication_factor: 1};"
      executeStatement(query, "", true)
    }
  }

  test("Create existing KS") {
    within(7000 millis) {
      val query = "create KEYSPACE ks_demo WITH replication = {class: SimpleStrategy, replication_factor: 1};"
      executeStatement(query, "", false)
    }
  }

  test("Use keyspace") {
    within(5000 millis) {
      val query = "use ks_demo ;"
      executeStatement(query, "", true)
    }
  }

  test("Use non-existing keyspace") {
    within(7000 millis) {
      val query = "use unknown ;"
      executeStatement(query, "", false)
    }
  }

  test("Insert into non-existing table") {
    within(7000 millis) {
      val query = "insert into demo (field1, field2) values ('test1','text2');"
      executeStatement(query, "ks_demo", false)
    }
  }

  test("Create table") {
    within(5000 millis) {
      val query = "create TABLE demo (field1 varchar PRIMARY KEY , field2 varchar);"
      executeStatement(query, "ks_demo", true)
    }
  }

  test("Create existing table") {
    within(7000 millis) {
      val query = "create TABLE demo (field1 varchar PRIMARY KEY , field2 varchar);"
      executeStatement(query, "ks_demo", false)
    }
  }

  test("Insert into table") {
    within(5000 millis) {
      val query = "insert into demo (field1, field2) values ('text1','text2');"
      executeStatement(query, "ks_demo", true)
    }
  }

  test("Select") {
    within(5000 millis) {
      val query = "select * from demo ;"
      val result = executeStatement(query, "ks_demo", true)
      val r = result.asInstanceOf[QueryResult]
      assertFalse(result.hasError, "Error not expected: " + getErrorMessage(result))
      assertEquals(r.getResultSet.size(), 1, "Cannot retrieve data")
      val row = r.getResultSet.iterator().next()
      assertEquals(row.getCells.get("field1").getValue, "text1", "Invalid row content")
      assertEquals(row.getCells.get("field2").getValue, "text2", "Invalid row content")
    }
  }

  test("Drop table") {
    within(5000 millis) {
      val query = "drop table demo ;"
      executeStatement(query, "ks_demo", true)
    }
  }

  test("Drop keyspace") {
    within(5000 millis) {
      val query = "drop keyspace ks_demo ;"
      executeStatement(query, "ks_demo", true)
    }
  }

  test("Drop non-existing keyspace") {
    within(7000 millis) {
      val query = "drop keyspace ks_demo ;"
      executeStatement(query, "ks_demo", false)
    }
  }

}









