/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir.cli.cmd;

import com.elega9t.commons.entity.impl.DefaultEntity;
import com.elega9t.commons.shell.Shell;
import com.elega9t.commons.shell.intrprtr.Command;
import com.elega9t.commons.shell.intrprtr.RequiredContextElement;
import com.elega9t.elixir.Connection;
import com.elega9t.elixir.cli.SqlInterpreter;

import java.io.BufferedReader;
import java.io.PrintStream;

public class SqlCommand extends DefaultEntity implements Command {

    @RequiredContextElement(name="elixir-connection", notSetMessage = "No database connection exists. Please connect to a database first.")
    private Connection connection;

    public SqlCommand() {
        super("sql");
    }

    @Override
    public int execute(Shell shell, BufferedReader in, PrintStream out) throws Exception {
        shell.switchInterpreter(new SqlInterpreter(connection));
        return 0;
    }

}
