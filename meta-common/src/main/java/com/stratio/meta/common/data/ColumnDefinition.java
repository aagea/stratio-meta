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

package com.stratio.meta.common.data;

import java.io.Serializable;

public class ColumnDefinition implements Serializable {

    private static final long serialVersionUID = 4958734787690152927L;

    private Class<?> datatype;

    public ColumnDefinition() {
        this.datatype = null;
    }

    /**
     * Constructor
     *
     * @param datatype Class of the value
     */
    public ColumnDefinition(Class<?> datatype) {
        this.datatype = datatype;
    }

    /**
     * Get the datatype of the cell.
     *
     * @return Datatype of the cell.
     */
    public Class<?> getDatatype() {
        return datatype;
    }

    public void setDatatype(Class<?> datatype) {
        this.datatype = datatype;
    }
}
