package com.stratio.meta.server.query

import akka.actor.ActorSystem
import com.stratio.meta.core.engine.{Engine, EngineConfig}
import org.testng.annotations.{AfterClass, Test}
import akka.testkit.TestActorRef
import com.stratio.meta.server.actors.QueryActor
import akka.pattern.ask
import com.stratio.meta.common.ask.Query
import com.stratio.meta.common.result.Result
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import org.apache.log4j.Logger
import scala.sys.process._
import java.io.File

class QueryActorTest{
  
  val logger: Logger = Logger.getLogger(classOf[Result])
  val system: ActorSystem = ActorSystem.create("TestSystem")
  val engineConfig: EngineConfig = {
    val result=new EngineConfig
    result.setCassandraHosts(Array[String]("127.0.0.1"))
    result.setCassandraPort(9042)
    result.setSparkMaster("local[2]")
    result.setClasspathJars("");
    result
  }
  lazy val engine: Engine = new Engine(engineConfig)

  @AfterClass
  def tearDownAfterClass(){
    engine.shutdown()
  }


  @Test def basicTest() = {
    val queryActor = TestActorRef.create(system,QueryActor.props(engine))
    val createKs: String = "CREATE KEYSPACE testKS WITH replication = {class: SimpleStrategy, replication_factor: 1};"

    val futureCreate: Future[Any] = queryActor.ask(new Query("system",createKs, "test"))(1000 second)
    val resultCreate= Await.result(futureCreate.mapTo[Result],1000 second)
    logger.info(resultCreate)


    val dropKs: String = "DROP KEYSPACE testks;"

    val futureDrop: Future[Any] = queryActor.ask(new Query("system",dropKs, "test"))(1000 second)
    val resultDrop= Await.result(futureDrop.mapTo[Result],1000 second)
    logger.info(resultDrop)


  }
}

