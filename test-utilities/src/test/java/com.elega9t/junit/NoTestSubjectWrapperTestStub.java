/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.junit;

import org.junit.runner.RunWith;

import java.sql.Connection;

@RunWith(WrapperTestRunner.class)
public class NoTestSubjectWrapperTestStub {

    @MockTarget(Connection.class)
    private Connection mock;

}
