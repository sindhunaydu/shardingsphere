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

package org.apache.shardingsphere.infra.binder.segment.expression.impl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.infra.binder.segment.from.TableSegmentBinderContext;
import org.apache.shardingsphere.infra.metadata.ShardingSphereMetaData;
import org.apache.shardingsphere.sql.parser.sql.common.segment.dml.expr.ExistsSubqueryExpression;
import org.apache.shardingsphere.sql.parser.sql.common.segment.dml.expr.subquery.SubquerySegment;

import java.util.Map;

/**
 * Exists subquery expression binder.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExistsSubqueryExpressionBinder {
    
    /**
     * Bind exists subquery expression with metadata.
     *
     * @param segment exists subquery expression segment
     * @param metaData metaData
     * @param defaultDatabaseName default database name
     * @param tableBinderContexts table binder contexts
     * @return bounded exists subquery expression segment
     */
    public static ExistsSubqueryExpression bind(final ExistsSubqueryExpression segment, final ShardingSphereMetaData metaData, final String defaultDatabaseName,
                                                final Map<String, TableSegmentBinderContext> tableBinderContexts) {
        SubquerySegment boundedSubquery = SubquerySegmentBinder.bind(segment.getSubquery(), metaData, defaultDatabaseName, tableBinderContexts);
        ExistsSubqueryExpression result = new ExistsSubqueryExpression(segment.getStartIndex(), segment.getStopIndex(), boundedSubquery);
        result.setNot(segment.isNot());
        return result;
    }
}
