/*
 * Licensed to STRATIO (C) under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.  The STRATIO (C) licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.stratio.meta2.core.query;

import java.util.List;

import com.stratio.meta.common.result.QueryStatus;
import com.stratio.meta.common.statements.structures.relationships.Relation;
import com.stratio.meta.core.structures.InnerJoin;
import com.stratio.meta2.common.data.ColumnName;
import com.stratio.meta2.common.data.TableName;
import com.stratio.meta2.common.metadata.TableMetadata;

public class SelectValidatedQuery extends SelectParsedQuery implements ValidatedQuery {

    private List<TableMetadata> tableMetadata;
    private List<ColumnName> columns;
    private List<Relation> relationships;
    private List<TableName> tables;
    private InnerJoin join;

    public SelectValidatedQuery(SelectParsedQuery selectParsedQuery) {
        super(selectParsedQuery);
        setQueryStatus(QueryStatus.VALIDATED);
    }

    public SelectValidatedQuery(SelectValidatedQuery selectValidatedQuery) {
        this((SelectParsedQuery) selectValidatedQuery);
    }

    public List<TableMetadata> getTableMetadata() {
        return tableMetadata;
    }

    public void setTableMetadata(List<TableMetadata> tableMetadata) {
        this.tableMetadata = tableMetadata;
    }

    public List<ColumnName> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnName> columns) {
        this.columns = columns;
    }

    public List<Relation> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relation> relationships) {
        this.relationships = relationships;
    }

    public List<TableName> getTables() {
        return tables;
    }

    public void setTables(List<TableName> tables) {
        this.tables = tables;
    }

    public InnerJoin getJoin() {
        return join;
    }

    public void setJoin(InnerJoin join) {
        this.join = join;
    }

}

