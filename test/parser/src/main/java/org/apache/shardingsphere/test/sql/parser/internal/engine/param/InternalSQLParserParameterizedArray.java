/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.test.sql.parser.internal.engine.param;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.shardingsphere.test.runner.param.ParameterizedArray;
import org.apache.shardingsphere.test.sql.parser.internal.cases.sql.type.SQLCaseType;

/**
 * Internal SQL parser parameterized array.
 */
@RequiredArgsConstructor
@Getter
public final class InternalSQLParserParameterizedArray implements ParameterizedArray {
    
    private final String sqlCaseId;
    
    private final String databaseType;
    
    private final SQLCaseType sqlCaseType;
    
    @Override
    public String toString() {
        return String.format("%s (%s) -> %s", sqlCaseId, sqlCaseType, databaseType);
    }
}
