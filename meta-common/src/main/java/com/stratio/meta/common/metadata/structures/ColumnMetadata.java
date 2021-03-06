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

package com.stratio.meta.common.metadata.structures;

import java.io.Serializable;

import com.stratio.meta2.common.metadata.ColumnType;

public class ColumnMetadata implements Serializable {

    /**
     * Serial version UID in order to be Serializable.
     */
    private static final long serialVersionUID = -2151960196552242173L;

    /**
     * Parent table.
     */
    private final String tableName;

    /**
     * Name of the column.
     */
    private final String columnName;

    /**
     * Alias of the column.
     */
    private String columnAlias;

    /**
     * Column type.
     */
    private ColumnType type;

    /**
     * Class constructor.
     *
     * @param tableName  Parent table name.
     * @param columnName Column name.
     */
    public ColumnMetadata(String tableName, String columnName) {
        this.tableName = tableName;
        this.columnName = columnName;
    }

    public ColumnMetadata(String tableName, String columnName,
            ColumnType type) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.type = type;
    }

    public String getTableName() {
        return tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getColumnNameToShow() {
        return (this.columnAlias == null) ? this.columnName : this.columnAlias;
    }

    /**
     * Get the column type.
     *
     * @return A {@link com.stratio.meta2.common.metadata.ColumnType}.
     */
    public ColumnType getType() {
        return type;
    }

    /**
     * Set the column type.
     *
     * @param type The column type.
     */
    public void setType(ColumnType type) {
        this.type = type;
    }

    public String getColumnAlias() {
        return columnAlias;
    }

    public void setColumnAlias(String columnAlias) {
        this.columnAlias = columnAlias;
    }

    @Override
    public String toString() {
        return this.columnName + ' ' + this.getType();
    }
}
