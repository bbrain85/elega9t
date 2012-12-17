/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir.gui.entity;

import com.elega9t.commons.entity.impl.EntityLoadException;
import com.elega9t.elixir.TableType;

public class TableTypeGuiEntity extends DatabaseGuiEntity<DatabaseGuiEntity> {

    private final TableType tableType;

    public TableTypeGuiEntity(TableType tableType) {
        super(tableType.getName(), new javax.swing.ImageIcon(ConnectionGuiEntity.class.getResource("/com/elega9t/elixir/gui/icons/database_tables.png")));
        this.tableType = tableType;
    }

    @Override
    protected void loadChildren() throws EntityLoadException {
        super.loadChildren();
        loadChildren(tableType);
    }

}
