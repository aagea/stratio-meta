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

package com.stratio.meta2.core.validator.statements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.stratio.meta.common.exceptions.IgnoreQueryException;
import com.stratio.meta.common.exceptions.ValidationException;
import com.stratio.meta2.common.data.CatalogName;
import com.stratio.meta2.common.data.ClusterName;
import com.stratio.meta2.common.data.ColumnName;
import com.stratio.meta2.common.data.TableName;
import com.stratio.meta2.common.metadata.ColumnType;
import com.stratio.meta2.common.statements.structures.selectors.StringSelector;
import com.stratio.meta2.core.query.BaseQuery;
import com.stratio.meta2.core.query.MetadataParsedQuery;
import com.stratio.meta2.core.query.ParsedQuery;
import com.stratio.meta2.core.statements.CreateTableStatement;
import com.stratio.meta2.core.structures.Property;
import com.stratio.meta2.core.structures.PropertyNameValue;
import com.stratio.meta2.core.validator.BasicValidatorTest;
import com.stratio.meta2.core.validator.Validator;

public class CreateTableStatementTest extends BasicValidatorTest {

    @Test
    public void createTable() {
        String query = "CREATE TABLE demo.users2 ( name varchar, gender varchar, age int, PRIMARY KEY (name)) ";

        Map<ColumnName, ColumnType> columns = new HashMap<>();
        List<ColumnName> primaryKey = new ArrayList<>();
        ColumnName partitionColumn1 = new ColumnName("demo", "users2", "name");
        primaryKey.add(partitionColumn1);

        columns.put(new ColumnName(new TableName("demo", "users2"), "name"), ColumnType.TEXT);
        columns.put(new ColumnName(new TableName("demo", "users2"), "gender"), ColumnType.TEXT);
        columns.put(new ColumnName(new TableName("demo", "users2"), "age"), ColumnType.INT);

        List<ColumnName> clusterKey = null;
        CreateTableStatement createTableStatement = new CreateTableStatement(new TableName("demo", "users2"),
                new ClusterName("cluster"),
                columns,
                primaryKey,
                clusterKey);
        Validator validator = new Validator();

        BaseQuery baseQuery = new BaseQuery("CreateTableId", query, new CatalogName("demo"));

        ParsedQuery parsedQuery = new MetadataParsedQuery(baseQuery, createTableStatement);
        try {
            validator.validate(parsedQuery);
            Assert.assertTrue(true);
        } catch (ValidationException e) {
            Assert.fail(e.getMessage());
        } catch (IgnoreQueryException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void CreateTableWithOptions() {
        String query = "CREATE TABLE demo.users2 ( name varchar, gender varchar, age int, PRIMARY KEY (name)) WITH comment='Users2 table'";
        Map<ColumnName, ColumnType> columns = new HashMap<>();
        List<ColumnName> primaryKey = new ArrayList<>();
        ColumnName partitionColumn1 = new ColumnName("demo", "users2", "name");
        primaryKey.add(partitionColumn1);

        columns.put(new ColumnName(new TableName("demo", "users2"), "name"), ColumnType.TEXT);
        columns.put(new ColumnName(new TableName("demo", "users2"), "gender"), ColumnType.TEXT);
        columns.put(new ColumnName(new TableName("demo", "users2"), "age"), ColumnType.INT);

        List<ColumnName> clusterKey = null;
        CreateTableStatement createTableStatement = new CreateTableStatement(new TableName("demo", "users2"),
                new ClusterName("cluster"),
                columns,
                primaryKey,
                clusterKey);

        createTableStatement.setProperties("{'comment': 'Users2 table'}");
        Validator validator = new Validator();

        BaseQuery baseQuery = new BaseQuery("CreateTableId", query, new CatalogName("demo"));

        ParsedQuery parsedQuery = new MetadataParsedQuery(baseQuery, createTableStatement);
        try {
            validator.validate(parsedQuery);
            Assert.assertTrue(true);
        } catch (ValidationException e) {
            Assert.fail(e.getMessage());
        } catch (IgnoreQueryException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void CreateTableUnknownCatalog() {
        String query = "CREATE TABLE unknown.users2 ( name varchar, gender varchar, age int, PRIMARY KEY (name))";
        Map<ColumnName, ColumnType> columns = new HashMap<>();
        List<ColumnName> primaryKey = new ArrayList<>();
        ColumnName partitionColumn1 = new ColumnName("unknown", "users2", "name");
        primaryKey.add(partitionColumn1);

        columns.put(new ColumnName(new TableName("unknown", "users2"), "name"), ColumnType.TEXT);
        columns.put(new ColumnName(new TableName("unknown", "users2"), "gender"), ColumnType.TEXT);
        columns.put(new ColumnName(new TableName("unknown", "users2"), "age"), ColumnType.INT);

        CreateTableStatement createTableStatement = new CreateTableStatement(new TableName("unknown", "users2"),
                new ClusterName("cluster"), columns, primaryKey, null);

        List<Property> properties = new ArrayList<>();
        Property prop = new PropertyNameValue(new StringSelector("comment"), new StringSelector("Users2 table"));
        properties.add(prop);

        createTableStatement.setProperties(properties.toString());
        Validator validator = new Validator();

        BaseQuery baseQuery = new BaseQuery("CreateTableId", query, new CatalogName("unknown"));

        ParsedQuery parsedQuery = new MetadataParsedQuery(baseQuery, createTableStatement);
        try {
            validator.validate(parsedQuery);
            Assert.fail("Catalog must exists");
        } catch (ValidationException e) {
            Assert.assertTrue(true);
        } catch (IgnoreQueryException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void createDuplicateTable() {
        String query = "CREATE TABLE demo.users ( name varchar, gender varchar, age int, PRIMARY KEY (name)) ";

        Map<ColumnName, ColumnType> columns = new HashMap<>();
        List<ColumnName> primaryKey = new ArrayList<>();
        ColumnName partitionColumn1 = new ColumnName("demo", "user", "name");
        primaryKey.add(partitionColumn1);

        columns.put(new ColumnName(new TableName("demo", "user"), "name"), ColumnType.TEXT);
        columns.put(new ColumnName(new TableName("demo", "user"), "gender"), ColumnType.TEXT);
        columns.put(new ColumnName(new TableName("demo", "user"), "age"), ColumnType.INT);

        CreateTableStatement createTableStatement = new CreateTableStatement(new TableName("demo", "user"),
                new ClusterName("cluster"), columns, primaryKey, null);
        Validator validator = new Validator();

        BaseQuery baseQuery = new BaseQuery("CreateTableId", query, new CatalogName("demo"));

        ParsedQuery parsedQuery = new MetadataParsedQuery(baseQuery, createTableStatement);
        try {
            validator.validate(parsedQuery);
            Assert.fail("The new table must not exists");
        } catch (ValidationException e) {
            Assert.assertTrue(true);
        } catch (IgnoreQueryException e) {
            Assert.assertTrue(true);
        }
    }

}
