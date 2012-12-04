/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir;

import com.elega9t.commons.entity.DefaultLazyLoadEntityNode;
import com.elega9t.commons.entity.EntityLoadException;

public class DatabaseEntity<T extends DatabaseEntity> extends DefaultLazyLoadEntityNode<T> {

    private final Connection connection;

    public DatabaseEntity(String name, Connection connection) throws EntityLoadException {
        super(name);
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

}
