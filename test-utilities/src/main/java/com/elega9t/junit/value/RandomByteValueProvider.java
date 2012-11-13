/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.junit.value;

public class RandomByteValueProvider extends RandomValueProvider {

    protected RandomByteValueProvider() {
        super(byte.class, Byte.class);
    }

    @Override
    public Object create() {
        byte[] value = new byte[1];
        RANDOM.nextBytes(value);
        return value[0];
    }

}
