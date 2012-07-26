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
package org.apache.hadoop.hbase.htrace.impl;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;

/**
 * Span that roots the span tree in a process, but perhaps not the whole trace.
 * 
 */
@InterfaceAudience.Public
@InterfaceStability.Evolving
public class RootMilliSpan extends MilliSpan {

  private final long traceId;
  private final long parentId;
 
  @Override
  public long getTraceId() {
    return traceId;
  }

  public RootMilliSpan(String description, long traceId, long spanId,
      long parentId,
      String processId) {
    super(description, spanId, null, processId);
    this.traceId = traceId;
    this.parentId = parentId;
  }

  public long getParentId() {
    return parentId;
  }
}