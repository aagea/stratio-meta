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

package com.stratio.meta.rest.utils;

import java.util.HashMap;

import com.stratio.meta.common.result.CommandResult;
import com.stratio.meta.common.result.IResultHandler;
import com.stratio.meta.common.result.QueryResult;
import com.stratio.meta.common.result.QueryStatus;
import com.stratio.meta.common.result.Result;

public class RestResultHandler implements IResultHandler {

    private QueryStatus status;
    private String queryId;
    private Result errorResult;
    private HashMap<String, Result> lastResults = new HashMap<String, Result>();

    public RestResultHandler() {
        status = QueryStatus.NONE;
        queryId = "";
        errorResult = null;
    }

    @Override
    public void processAck(String queryId, QueryStatus status) {
        this.queryId = queryId;
        this.status = status;
    }

    @Override
    public void processError(Result errorResult) {
        this.errorResult = errorResult;
    }

    @Override
    public void processResult(Result result) {
        this.queryId = result.getQueryId();
        if (QueryResult.class.isInstance(result)) {
            QueryResult r = QueryResult.class.cast(result);
            QueryResult last = (QueryResult) lastResults.get(queryId);
            if (last == null) { // no hay resultado anterior
                lastResults.put(queryId, r);
            } else {
                if (last.getResultPage() != r.getResultPage()) { // result es nuevo
                    // TODO: Update with new structure
                    //((MetaResultSet) last.getResultSet()).getRows().addAll(((MetaResultSet) r.getResultSet()).getRows());// concatena con los resultados anteriores
                    // lastResults.put(queryId, r); // actualizamos el anterior result con el actual
                    // queryResult.getResultSet.asInstanceOf[MetaResultSet].getRows.addAll(
                    // r.getResultSet.asInstanceOf[MetaResultSet].getRows)
                }
            }
        } else if (CommandResult.class.isInstance(result)) {
            CommandResult r = CommandResult.class.cast(result);
            CommandResult last = (CommandResult) lastResults.get(queryId);
            if (last == null) {
                lastResults.put(queryId, r);
            }
        }
    }

    public QueryStatus getStatus() {
        return status;
    }

    public String getQueryId() {
        return queryId;
    }

    public Result getErrorResult() {
        return errorResult;
    }

    public Result getResult(String queryId) {
        Result result = lastResults.get(queryId);
        lastResults.remove(queryId);
        return result;
    }

}
