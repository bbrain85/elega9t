/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir.gui.entity;

import com.elega9t.elixir.Columns;

public class ColumnsGuiEntity extends DatabaseGuiEntity<DatabaseGuiEntity, Columns> {

    public ColumnsGuiEntity(Columns columns) {
        super(columns.getName(), new javax.swing.ImageIcon(ConnectionGuiEntity.class.getResource("/com/elega9t/elixir/gui/icons/table_columns.png")));
        this.databaseEntity = columns;
    }

}
