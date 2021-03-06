package com.stratio.connectors.config

import java.io.File

import com.typesafe.config.{Config, ConfigFactory}
import org.apache.log4j.Logger


object ConnectConfig {
  val CONNECTOR_BASIC_CONFIG = "connector-reference.conf"
  val PARENT_CONFIG_NAME = "meta-connector"


  val CONNECTOR_CLUSTER_NAME_KEY = "config.cluster.name"
  val CONNECTOR_ACTOR_NAME_KEY = "config.cluster.actor"
  val CONNECTOR_USER_CONFIG_FILE = "external.config.filename"
  val CONNECTOR_USER_CONFIG_RESOURCE = "external.config.resource"
  val CONNECTOR_NAME = "config.connector.name"
  val CONNECTOR_ACTOR_NUM = "config.akka.number.connector-actor"
}

trait ConnectConfig {

  lazy val logger: Logger = ???
  lazy val clusterName = config.getString(ConnectConfig.CONNECTOR_CLUSTER_NAME_KEY)
  lazy val actorName = config.getString(ConnectConfig.CONNECTOR_ACTOR_NAME_KEY)
  lazy val connectorName = config.getString(ConnectConfig.CONNECTOR_NAME)
  lazy val num_connector_actor: Int = config.getString(ConnectConfig.CONNECTOR_ACTOR_NUM).toInt
  val config: Config = {

    var defaultConfig = ConfigFactory.load(ConnectConfig.CONNECTOR_BASIC_CONFIG).getConfig(ConnectConfig.PARENT_CONFIG_NAME)
    val configFile = defaultConfig.getString(ConnectConfig.CONNECTOR_USER_CONFIG_FILE)
    val configResource = defaultConfig.getString(ConnectConfig.CONNECTOR_USER_CONFIG_RESOURCE)

    if (configResource != "") {
      val resource = ConnectConfig.getClass.getClassLoader.getResource(configResource)
      if (resource != null) {
        val userConfig = ConfigFactory.parseResources(configResource).getConfig(ConnectConfig.PARENT_CONFIG_NAME)
        defaultConfig = userConfig.withFallback(defaultConfig)
      } else {
        logger.warn("User resource (" + configResource + ") haven't been found")
        val file = new File(configResource)
        if (file.exists()) {
          val userConfig = ConfigFactory.parseFile(file).getConfig(ConnectConfig.PARENT_CONFIG_NAME)
          defaultConfig = userConfig.withFallback(defaultConfig)
        } else {
          logger.warn("User file (" + configResource + ") haven't been found in classpath")
        }
      }
    }
    if (configFile != "") {
      val file = new File(configFile)
      if (file.exists()) {
        val userConfig = ConfigFactory.parseFile(file).getConfig(ConnectConfig.PARENT_CONFIG_NAME)
        defaultConfig = userConfig.withFallback(defaultConfig)
      } else {
        logger.warn("User file (" + configFile + ") haven't been found")
      }
    }

    ConfigFactory.load(defaultConfig)
  }

}
