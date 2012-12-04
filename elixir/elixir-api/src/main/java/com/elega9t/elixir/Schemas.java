/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir;

import com.elega9t.commons.entity.EntityLoadException;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Schemas extends DatabaseEntity<Schema> {

    private String catalogueName;

    public Schemas(String catalogueName, Connection connection) throws EntityLoadException {
        super("SCHEMAS", connection);
        this.catalogueName = catalogueName;
    }

    @Override
    protected void loadChildren() throws EntityLoadException {
        super.loadChildren();
        try {
            final DatabaseMetaData metaData = getConnection().getMetaData();
            ResultSet resultSet = metaData.getSchemas();
            while (resultSet.next()) {
                addChild(new Schema(catalogueName, resultSet.getString("TABLE_SCHEM"), getConnection()));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new EntityLoadException(e);
        }
    }

}
