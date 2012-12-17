/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.commons.entity;

import com.elega9t.commons.entity.impl.LifecycleListenerRunnableEntity;
import com.elega9t.commons.entity.impl.RunnableEntityException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LifecycleListenerRunnableEntityTest {

    private LifecycleListenerRunnableEntity test = new LifecycleListenerRunnableEntity("id", "name") {
        @Override
        protected void startEntity() throws RunnableEntityException {
        }
        @Override
        protected void stopEntity() throws RunnableEntityException {
        }
    };

    @Test
    public void startsEntityWhenStartingEventRecieved() throws Exception {
        assertEquals(RunnableUniqueEntity.STATUS.STOPPED, test.getStatus());
        test.lifecycleEventOccurred(RunnableUniqueEntity.STATUS.STARTING, null);

        assertEquals(RunnableUniqueEntity.STATUS.RUNNING, test.getStatus());
    }

    @Test
    public void stopsEntityWhenStoppingEventRecieved() throws Exception {
        assertEquals(RunnableUniqueEntity.STATUS.STOPPED, test.getStatus());
        test.start();

        assertEquals(RunnableUniqueEntity.STATUS.RUNNING, test.getStatus());
        test.lifecycleEventOccurred(RunnableUniqueEntity.STATUS.STOPPING, null);

        assertEquals(RunnableUniqueEntity.STATUS.STOPPED, test.getStatus());
    }

}
