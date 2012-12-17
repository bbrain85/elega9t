/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.commons.entity.tree.impl;

import com.elega9t.commons.entity.impl.EntityLoadException;
import com.elega9t.commons.entity.tree.EntityTreeNode;
import com.elega9t.commons.entity.LoadableEntity;

public class DefaultLazyLoadEntityTreeNode<T extends EntityTreeNode & LoadableEntity> extends DefaultLoadableEntityTreeNode<T> {

    public DefaultLazyLoadEntityTreeNode(String name) {
        super(name);
    }

    @Override
    public int getChildCount() {
        if(!loaded) {
            try {
                load();
            } catch (EntityLoadException e) {
                throw new IllegalStateException(e);
            }
        }
        return super.getChildCount();
    }

    @Override
    public T getChildAt(int index) {
        if(!loaded) {
            try {
                load();
            } catch (EntityLoadException e) {
                throw new IllegalStateException(e);
            }
        }
        return super.getChildAt(index);
    }

    @Override
    public void addChild(T node) {
        if(!loaded) {
            try {
                load();
            } catch (EntityLoadException e) {
                throw new IllegalStateException(e);
            }
        }
        super.addChild(node);
    }

    @Override
    public boolean removeChild(T node) {
        if(!loaded) {
            try {
                load();
            } catch (EntityLoadException e) {
                throw new IllegalStateException(e);
            }
        }
        return super.removeChild(node);
    }

}