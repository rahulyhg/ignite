/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.ignite.testsuites;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;
import org.apache.ignite.internal.util.IgniteUtils;
import org.apache.ignite.spi.communication.tcp.IgniteCacheSslStartStopSelfTest;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

/**
 * Test suite.
 */
@RunWith(AllTests.class)
public class IgniteCacheFailoverTestSuiteSsl {
    /**
     * @return Ignite Cache Failover test suite.
     */
    public static TestSuite suite() {
        TestSuite suite = new TestSuite("Cache Failover Test Suite SSL");

        // Disable SSL test with old JDK because of https://bugs.openjdk.java.net/browse/JDK-8013809.
        if (!IgniteUtils.isHotSpot() || IgniteUtils.isJavaVersionAtLeast("1.7.0_65"))
            suite.addTest(new JUnit4TestAdapter(IgniteCacheSslStartStopSelfTest.class));

        return suite;
    }
}
