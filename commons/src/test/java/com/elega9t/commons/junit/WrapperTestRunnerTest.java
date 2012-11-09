/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.commons.junit;

import org.junit.Test;

public class WrapperTestRunnerTest {

    @Test(expected = IllegalStateException.class)
    public void throwsExceptionWhenNoContactDefined() throws Exception {
        new WrapperTestRunner(NoContractWrapperTestStub.class);
    }

}