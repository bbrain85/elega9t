/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir.cli.cmd;

import com.elega9t.commons.entity.DefaultEntity;
import com.elega9t.commons.shell.Shell;
import com.elega9t.commons.shell.intrprtr.Command;
import com.elega9t.elixir.Connection;

import java.io.BufferedReader;
import java.io.PrintStream;

public class DisconnectCommand extends DefaultEntity implements Command {

    public DisconnectCommand() {
        super("disconnect");
    }

    @Override
    public int execute(Shell shell, BufferedReader in, PrintStream out) throws Exception {
        Connection connection = (Connection) shell.getContextElement("connection");
        if(connection != null) {
            connection.close();
            out.println("Connection closed.");
        } else {
            throw new IllegalArgumentException("No database connection exists. Please connect to a database first.");
        }
        return 0;
    }

}
