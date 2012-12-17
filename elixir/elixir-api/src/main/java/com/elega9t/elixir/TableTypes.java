/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir;

import com.elega9t.commons.entity.impl.EntityLoadException;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableTypes extends DatabaseEntity<TableType> {

    private final String catalogueName;
    private final Schema schema;

    public TableTypes(String catalogueName, String schemaName, Connection connection) throws EntityLoadException {
        this(catalogueName, new Schema(catalogueName, null, schemaName, connection), connection);
    }

    public TableTypes(String catalogueName, Schema schema, Connection connection) throws EntityLoadException {
        super("TABLES", schema, connection);
        this.catalogueName = catalogueName;
        this.schema = schema;
    }

    @Override
    public void load() throws EntityLoadException {
        try {
            final DatabaseMetaData metaData = getConnection().getMetaData();
            final ResultSet resultSet = metaData.getTableTypes();
            while (resultSet.next()) {
                addChild(new TableType(catalogueName, schema, resultSet.getString("TABLE_TYPE"), getConnection()));
            }
        } catch (SQLException e) {
            throw new EntityLoadException(e);
        } finally {
            loaded = true;
        }
    }

    @Override
    public <R> R visit(DatabaseEntityVisitor<R> visitor) {
        return visitor.visit(this);
    }

}
