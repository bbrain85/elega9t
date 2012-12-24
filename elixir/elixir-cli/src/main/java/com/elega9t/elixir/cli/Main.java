/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir.cli;

import com.elega9t.commons.entity.impl.EntityLoadException;
import com.elega9t.commons.shell.Shell;
import com.elega9t.commons.shell.intrprtr.Interpreter;
import com.elega9t.commons.shell.intrprtr.cmd.ExitCommand;
import com.elega9t.elixir.cli.cmd.ConnectCommand;
import com.elega9t.elixir.mgr.DriverManager;
import com.elega9t.elixir.mgr.PluginManager;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException, IllegalAccessException, InstantiationException {
        PluginManager.getInstance().addPluginProcessor(DriverManager.getInstance());
        try {
            PluginManager.getInstance().load();
        } catch (EntityLoadException e) {
            e.printStackTrace();
        }
        final Interpreter elx = new Interpreter("elx", ExitCommand.class.getPackage(), ConnectCommand.class.getPackage());
        Shell shell = new Shell(elx);
        shell.execute();
    }

}
