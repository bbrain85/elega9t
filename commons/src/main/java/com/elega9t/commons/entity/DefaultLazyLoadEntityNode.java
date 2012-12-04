/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.commons.entity;

public class DefaultLazyLoadEntityNode<T extends LoadableEntityNode> extends DefaultLoadableEntityNode<T> implements LoadableEntityNode<T> {

    private boolean childrenLoaded = false;

    public DefaultLazyLoadEntityNode(String name) throws EntityLoadException {
        super(name);
        load();
    }

    public void load() throws EntityLoadException {
    }

    protected void loadChildren() throws EntityLoadException {
        childrenLoaded = true;
    }

    @Override
    public int getChildCount() {
        if(!childrenLoaded) {
            try {
                loadChildren();
            } catch (EntityLoadException e) {
                throw new IllegalStateException(e);
            }
        }
        return super.getChildCount();
    }

    @Override
    public T getChild(int index) {
        if(!childrenLoaded) {
            try {
                loadChildren();
            } catch (EntityLoadException e) {
                throw new IllegalStateException(e);
            }
        }
        return super.getChild(index);
    }

    @Override
    public void addChild(T node) {
        if(!childrenLoaded) {
            try {
                loadChildren();
            } catch (EntityLoadException e) {
                throw new IllegalStateException(e);
            }
        }
        super.addChild(node);
    }

    @Override
    public boolean removeChild(T node) {
        if(!childrenLoaded) {
            try {
                loadChildren();
            } catch (EntityLoadException e) {
                throw new IllegalStateException(e);
            }
        }
        return super.removeChild(node);
    }

    @Override
    public void clear() {
        super.clear();
        childrenLoaded = false;
    }

}
