/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir;

import com.elega9t.junit.MockTarget;
import com.elega9t.junit.TestSubject;
import com.elega9t.junit.WrapperTestRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(WrapperTestRunner.class)
public class ConnectionTest {

    private static final String NAME = "DATABASE_NAME";

    @MockTarget(java.sql.Connection.class)
    private java.sql.Connection mockConnection;

    @TestSubject
    private Connection test;

    @Before
    public void setUp() throws Exception {
        test = new Connection(mockConnection, NAME);
    }

}
