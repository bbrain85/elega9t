/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir;

import com.elega9t.commons.entity.EntityLoadException;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tables extends DatabaseEntity<Table> {

    private final String catalogueName;
    private final String schemaName;

    public Tables(String catalogueName, String schemaName, Connection connection) {
        super("TABLES", connection);
        this.catalogueName = catalogueName;
        this.schemaName = schemaName;
    }

    @Override
    public void load() throws EntityLoadException {
        clear();
        try {
            final DatabaseMetaData metaData = getConnection().getMetaData();
            final ResultSet resultSet = metaData.getTables(catalogueName, schemaName, null, null);
            while (resultSet.next()) {
                addChild(new Table(resultSet.getString("TABLE_NAME"), getConnection()));
            }
        } catch (SQLException e) {
            throw new EntityLoadException(e);
        }
    }

}
