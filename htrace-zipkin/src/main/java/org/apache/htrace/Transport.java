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

package org.apache.htrace;

import org.apache.htrace.core.HTraceConfiguration;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * Span data transport interface.
 */
public interface Transport extends Closeable {

  /**
   * Open connection to Transport endpoint
   * @param conf Transport configuration
   * @throws IOException if an I/O error occurs
   */
  void open(HTraceConfiguration conf) throws IOException;

  /**
   * Checks if the transport in use is open
   * @return whether the transport is open
   */
  boolean isOpen();

  /**
   * Sends the list of objects to the transport endpoint
   * @param spans to be sent
   * @throws IOException if an I/O error occurs
   */
  void send(List<byte[]> spans) throws IOException;
}
