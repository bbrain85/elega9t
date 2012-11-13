/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.junit;

import com.elega9t.junit.value.RandomValueFactory;
import org.junit.internal.runners.model.ReflectiveCallable;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WrapperFrameworkMethod extends FrameworkMethod {

    private final FrameworkField subjectField;
    private final FrameworkField mockTargetField;

    public WrapperFrameworkMethod(Method method, FrameworkField subjectField, FrameworkField mockTargetField) {
        super(method);
        this.subjectField = subjectField;
        this.mockTargetField = mockTargetField;
        mockTargetField.getField().setAccessible(true);
        subjectField.getField().setAccessible(true);
    }

    @Override
    public Object invokeExplosively(final Object target, Object... params) throws Throwable {
        return new ReflectiveCallable() {
            @Override
            protected Object runReflectiveCall() throws Throwable {
                Object subject = subjectField.get(target);
                Object mockTarget = mockTargetField.get(target);
                Object returnValue = null;
                Object[] testParameters = RandomValueFactory.getInstance().create(getMethod().getParameterTypes());
                Object fromBase = null;
                Class<?> returnType = getMethod().getReturnType();
                if(notVoid(returnType)) {
                    fromBase = RandomValueFactory.getInstance().create(returnType);
                    when(getMethod().invoke(mockTarget, testParameters)).thenReturn(fromBase);
                }
                returnValue = getMethod().invoke(subject, testParameters);
                getMethod().invoke(verify(mockTarget), testParameters);
                if(notVoid(returnType)) {
                    assertEquals("return values are not equal.", fromBase, returnValue);
                }
                return returnValue;
            }
        }.run();
    }

    protected boolean notVoid(Class<?> clazz) {
        return clazz != Void.class && clazz != void.class;
    }

}