/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir.gui.entity;

import com.elega9t.commons.entity.impl.EntityLoadException;
import com.elega9t.elixir.Connection;
import com.elega9t.elixir.Driver;
import com.elega9t.elixir.gui.config.ConnectionDetails;
import com.elega9t.elixir.mgr.DriverManager;

import java.sql.SQLException;

public class ConnectionGuiEntity extends DatabaseGuiEntity<DatabaseGuiEntity, Connection> {

    private final ConnectionDetails connectionDetails;

    public ConnectionGuiEntity(ConnectionDetails connectionDetails) {
        super(connectionDetails.getName(), new javax.swing.ImageIcon(ConnectionGuiEntity.class.getResource("/com/elega9t/elixir/gui/icons/database.png")));
        this.connectionDetails = connectionDetails;
    }

    public ConnectionDetails getConnectionDetails() {
        return connectionDetails;
    }

    public void load() throws EntityLoadException {
        Driver driver = DriverManager.getInstance().getDriver(connectionDetails.getDriver());
        try {
            this.databaseEntity = driver.createConnection(connectionDetails.getUser(), connectionDetails.getPassword());
            super.load();
        } catch (SQLException e) {
            throw new EntityLoadException(e);
        } finally {
            loaded = true;
        }
    }

}
