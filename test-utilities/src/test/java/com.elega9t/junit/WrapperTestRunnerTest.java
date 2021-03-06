/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.junit;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.model.InitializationError;

@Ignore
public class WrapperTestRunnerTest {

    @Test(expected = InitializationError.class)
    public void throwsExceptionWhenNoTestSubject() throws Exception {
        new WrapperTestRunner(NoTestSubjectWrapperTestStub.class);
    }

}
