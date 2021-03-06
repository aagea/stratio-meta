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

package com.stratio.meta2.core.statements;

import com.stratio.meta2.common.metadata.ClusterMetadata;
import com.stratio.meta2.common.metadata.ColumnMetadata;
import com.stratio.meta2.common.metadata.ConnectorMetadata;
import com.stratio.meta2.common.metadata.DataStoreMetadata;
import com.stratio.meta2.common.metadata.TableMetadata;

public abstract class MetadataStatement extends MetaStatement {

    protected ClusterMetadata clusterMetadata = null;

    protected ConnectorMetadata connectorMetadata = null;

    protected DataStoreMetadata dataStoreMetadata = null;

    protected TableMetadata tableMetadata = null;

    protected ColumnMetadata columnMetadata = null;

    public MetadataStatement() {
        super();
    }

    public ClusterMetadata getClusterMetadata() {
        return clusterMetadata;
    }

    public void setClusterMetadata(ClusterMetadata clusterMetadata) {
        this.clusterMetadata = clusterMetadata;
    }

    public ConnectorMetadata getConnectorMetadata() {
        return connectorMetadata;
    }

    public void setConnectorMetadata(ConnectorMetadata connectorMetadata) {
        this.connectorMetadata = connectorMetadata;
    }

    public DataStoreMetadata getDataStoreMetadata() {
        return dataStoreMetadata;
    }

    public void setDataStoreMetadata(DataStoreMetadata dataStoreMetadata) {
        this.dataStoreMetadata = dataStoreMetadata;
    }

    public TableMetadata getTableMetadata() {
        return tableMetadata;
    }

    public void setTableMetadata(TableMetadata tableMetadata) {
        this.tableMetadata = tableMetadata;
    }

    public ColumnMetadata getColumnMetadata() {
        return columnMetadata;
    }

    public void setColumnMetadata(ColumnMetadata columnMetadata) {
        this.columnMetadata = columnMetadata;
    }

}
