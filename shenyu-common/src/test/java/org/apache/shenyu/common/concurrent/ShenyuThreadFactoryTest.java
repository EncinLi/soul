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

package org.apache.shenyu.common.concurrent;

import org.junit.Test;

import java.util.concurrent.ThreadFactory;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Test cases for ShenyuThreadFactory.
 */
public final class ShenyuThreadFactoryTest {

    private static final String NAME_PREFIX = "shenyu##thread##";

    @Test
    public void testCreate() {
        ThreadFactory threadFactory = ShenyuThreadFactory.create(NAME_PREFIX, true);
        assertThat(threadFactory, notNullValue());
    }

    @Test
    public void testCustomCreate() {
        ThreadFactory threadFactory = ShenyuThreadFactory.create(NAME_PREFIX, true, 2);
        Thread thread = threadFactory.newThread(() -> Thread.currentThread().getId());
        assertThat(thread, notNullValue());
    }

    @Test
    public void testNewThread() {
        ThreadFactory threadFactory = ShenyuThreadFactory.create(NAME_PREFIX, true);
        threadFactory.newThread(() -> Thread.currentThread().setName("NAME_PREFIX"));
    }
}
