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

package com.stratio.meta2.common.data;

public class DataStoreName extends FirstLevelName {
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 4171381082865700657L;
    private final String name;

    public DataStoreName(String dataStoreName) {
        super();
        this.name = dataStoreName;
    }

    public String getName() {
        return name;
    }

    public String getQualifiedName() {
        return QualifiedNames.getDataStoreQualifiedName(getName());
    }

    @Override public NameType getType() {
        return NameType.DataStore;
    }
}
