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

package com.stratio.meta2.common.statements.structures.selectors;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.stratio.meta2.common.data.ColumnName;
import com.stratio.meta2.common.data.TableName;

/**
 * Single column selector.
 */
public class ColumnSelector extends Selector {

    /**
     * Name of the selected column.
     */
    private ColumnName name;

    public ColumnSelector(ColumnName name) {
        this.name = name;
    }

    public ColumnName getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name.toString());
        if (this.alias != null) {
            sb.append(" AS ").append(alias);
        }
        return sb.toString();
    }

    @Override public SelectorType getType() {
        return SelectorType.COLUMN;
    }

    @Override
    public Set<TableName> getSelectorTables() {
        return new HashSet(Arrays.asList(this.name.getTableName()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ColumnSelector that = (ColumnSelector) o;

        if (!alias.equals(that.alias)) {
            return false;
        }
        if (!name.equals(that.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        if (alias != null){
            result = alias.hashCode();
        }
        result = 31 * result + name.hashCode();
        return result;
    }
}
