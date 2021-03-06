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

package com.stratio.meta2.common.metadata;

import java.util.Map;

import com.stratio.meta2.common.data.CatalogName;
import com.stratio.meta2.common.data.TableName;
import com.stratio.meta2.common.statements.structures.selectors.Selector;

public class CatalogMetadata implements IMetadata {
    private final CatalogName name;

    private final Map<Selector, Selector> options;

    private final Map<TableName, TableMetadata> tables;

    public CatalogMetadata(CatalogName name, Map<Selector, Selector> options,
            Map<TableName, TableMetadata> tables) {
        this.name = name;
        this.options = options;
        this.tables = tables;
    }

    public final CatalogName getName() {
        return name;
    }

    public Map<Selector, Selector> getOptions() {
        return options;
    }

    public Map<TableName, TableMetadata> getTables() {
        return tables;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }
}
