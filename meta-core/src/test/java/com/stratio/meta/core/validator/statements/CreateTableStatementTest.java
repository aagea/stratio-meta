/*
 * Stratio Meta
 *
 * Copyright (c) 2014, Stratio, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */

package com.stratio.meta.core.validator.statements;

import com.stratio.meta.core.validator.BasicValidatorTest;
import org.testng.annotations.Test;

public class CreateTableStatementTest extends BasicValidatorTest {

  @Test
  public void validateBasicOk(){
    String inputText = "CREATE TABLE demo.new_table (id INT, name VARCHAR, check BOOLEAN, PRIMARY KEY (id, name));";
    validateOk(inputText, "validateBasicOk");
  }

  @Test
  public void validateAllSupportedOk(){
    String inputText = "CREATE TABLE demo.new_table (id INT, name VARCHAR, check BOOLEAN, PRIMARY KEY (id, name));";
    validateOk(inputText, "validateAllSupportedOk");
  }

  @Test
  public void validateIfNotExitsOk(){
    String inputText = "CREATE TABLE IF NOT EXISTS demo.users (name VARCHAR, gender VARCHAR, email VARCHAR, age INT, bool BOOLEAN, phrase VARCHAR, PRIMARY KEY ((name, gender), email, age));";
    validateOk(inputText, "validateIfNotExitsOk");
  }

  @Test
  public void validateEphemeralOk(){
    String inputText = "CREATE TABLE demo.temporal (name VARCHAR, gender VARCHAR, email VARCHAR, age INT, bool BOOLEAN, phrase VARCHAR, PRIMARY KEY (name))"
                       + " WITH ephemeral=true;";
    validateOk(inputText, "validateEphemeralOk");
  }

  @Test
  public void validatePkNotDeclared(){
    String inputText = "CREATE TABLE IF NOT EXISTS demo.users (name VARCHAR, gender VARCHAR, email VARCHAR, age INT, bool BOOLEAN, phrase VARCHAR, PRIMARY KEY ((unknown, gender), email, age));";
    validateFail(inputText, "validatePkNotDeclared");
  }

  @Test
  public void validateCkNotDeclared(){
    String inputText = "CREATE TABLE IF NOT EXISTS demo.users (name VARCHAR, gender VARCHAR, email VARCHAR, age INT, bool BOOLEAN, phrase VARCHAR, PRIMARY KEY ((name, gender), unknown, age));";
    validateFail(inputText, "validateCkNotDeclared");
  }

  @Test
  public void validateUnsupportedType(){
    String [] unsupported = {
        "ASCII",  "BLOB",   "DECIMAL",
        "INET",   "TEXT",   "TIMESTAMP",
        "UUID",   "VARINT", "TIMEUUID",
        "UNKNOWN"};
    for(String u : unsupported) {
      String inputText = "CREATE TABLE demo.table_fail (id " + u +", PRIMARY KEY (id));";
      validateFail(inputText, "validate_unsupportedType: " + u);
    }
  }

  @Test
  public void validateStratioColumnFail(){
    String inputText = "CREATE TABLE demo.table_fail (name VARCHAR, stratio_column VARCHAR, PRIMARY KEY (name));";
    validateFail(inputText, "validate_stratioColumnFail");
  }
}
