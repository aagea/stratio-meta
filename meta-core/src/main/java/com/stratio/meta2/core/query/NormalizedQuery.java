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

package com.stratio.meta2.core.query;

import java.util.List;

import com.stratio.meta.common.result.QueryStatus;
import com.stratio.meta.common.statements.structures.relationships.Relation;
import com.stratio.meta2.common.data.CatalogName;
import com.stratio.meta2.common.data.ColumnName;
import com.stratio.meta2.common.data.TableName;
import com.stratio.meta2.common.metadata.TableMetadata;

public abstract class NormalizedQuery extends SelectParsedQuery {
    public NormalizedQuery(SelectParsedQuery parsedQuery) {
        super(parsedQuery);
    }

    NormalizedQuery(NormalizedQuery normalizedQuery) {
        this((SelectParsedQuery) normalizedQuery);
    }

    public QueryStatus getStatus() {
        return QueryStatus.NORMALIZED;
    }

    //IStatement Methods move to MetaStatement
    public List<CatalogName> getCatalogs() {
        throw new UnsupportedOperationException();
    }

    public List<TableName> getTables() {
        throw new UnsupportedOperationException();
    }

    public List<ColumnName> getColumns() {
        throw new UnsupportedOperationException();
    }

    public List<Relation> getAssignations() {
        throw new UnsupportedOperationException();
    }

    public List<Relation> getRelationships() {
        throw new UnsupportedOperationException();
    }

    public List<TableMetadata> getTableMetadata() {
        throw new UnsupportedOperationException();
    }

    //public List<OrderBy> getOrderByColumns();
    //OrderBy-> List<Columns> order (ASC, DESC)

    //public List<Selector> groupBy, getJoin, ....

}
