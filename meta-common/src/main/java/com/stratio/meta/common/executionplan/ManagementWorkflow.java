/*
 * Licensed to STRATIO (C) under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.  The STRATIO (C) licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.stratio.meta.common.executionplan;

import java.io.Serializable;
import java.util.Map;

import com.stratio.meta.communication.AttachCluster;
import com.stratio.meta.communication.AttachConnector;
import com.stratio.meta.communication.DetachCluster;
import com.stratio.meta.communication.DetachConnector;
import com.stratio.meta.communication.ManagementOperation;
import com.stratio.meta2.common.data.ClusterName;
import com.stratio.meta2.common.data.ConnectorName;
import com.stratio.meta2.common.data.DataStoreName;
import com.stratio.meta2.common.statements.structures.selectors.Selector;

/**
 * Execute operations related with connector and cluster management.
 */
public class ManagementWorkflow extends ExecutionWorkflow {

    /**
     * Name of the cluster.
     */
    private ClusterName clusterName = null;

    /**
     * Name of the datastore.
     */
    private DataStoreName datastoreName = null;

    /**
     * Name of the connector.
     */
    private ConnectorName connectorName = null;

    /**
     * A JSON with the options.
     */
    private Map<Selector, Selector> options = null;

    /**
     * Class constructor.
     *
     * @param queryId       Query identifer.
     * @param actorRef      Target actor reference.
     * @param executionType Type of execution.
     * @param type          Type of results.
     */
    public ManagementWorkflow(String queryId, Serializable actorRef,
            ExecutionType executionType, ResultType type) {
        super(queryId, actorRef, executionType, type);
    }

    public void setClusterName(ClusterName clusterName) {
        this.clusterName = clusterName;
    }

    public void setDatastoreName(DataStoreName datastoreName) {
        this.datastoreName = datastoreName;
    }

    public void setConnectorName(ConnectorName connectorName) {
        this.connectorName = connectorName;
    }

    public void setOptions(Map<Selector, Selector> options) {
        this.options = options;
    }

    public ManagementOperation getManagementOperation(String queryId) {
        ManagementOperation result = null;
        if (ExecutionType.ATTACH_CLUSTER.equals(this.executionType)) {
            result = new AttachCluster(queryId, this.clusterName, this.datastoreName, this.options);
        } else if (ExecutionType.DROP_CATALOG.equals(this.executionType)) {
            result = new DetachCluster(queryId, this.clusterName);
        } else if (ExecutionType.ATTACH_CONNECTOR.equals(this.executionType)) {
            result = new AttachConnector(queryId, this.clusterName, this.connectorName, this.options);
        } else if (ExecutionType.DETACH_CONNECTOR.equals(this.executionType)) {
            result = new DetachConnector(queryId, this.clusterName, this.connectorName);
        }
        return result;
    }

}
