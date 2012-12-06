/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.elega9t.commons.transform.impl;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StringToDoubleTwoWayTransformerTest {
    
    private StringToDoubleTwoWayTransformer test = StringToDoubleTwoWayTransformer.getInstance();
    
    @Test
    public void fromClassIsJustString() throws Exception {
        assertArrayEquals(new Class[] { String.class }, test.getFromClasses());
    }

    @Test
    public void toClassHasBothPrimitiveAndWrapperClasses() throws Exception {
        assertArrayEquals(new Class[] { double.class, Double.class }, test.getToClasses());
    }

    @Test
    public void canTransformToDouble() throws Exception {
        assertEquals(92.43, test.transform("92.43"), 0.001);
    }

    @Test
    public void canTransformFromDouble() throws Exception {
        assertEquals("74.26", test.transformFrom(74.26d));
    }

}
