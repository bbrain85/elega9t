/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir.cli.cmd;

import com.elega9t.commons.entity.DefaultEntity;
import com.elega9t.commons.renderer.table.ColumnDataModel;
import com.elega9t.commons.renderer.table.TableToStringRenderer;
import com.elega9t.commons.renderer.table.ObjectCollectionDataModel;
import com.elega9t.commons.shell.Shell;
import com.elega9t.commons.shell.intrprtr.Command;
import com.elega9t.commons.shell.intrprtr.Parameter;
import com.elega9t.commons.shell.intrprtr.RequiredContextElement;
import com.elega9t.elixir.Driver;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static com.elega9t.commons.util.StringUtilities.join;

public class ListCommand extends DefaultEntity implements Command {

    @RequiredContextElement(name="elixir-drivers", notSetMessage = "No drivers are available.")
    private Map<String, Driver> drivers;

    private static final Map<String, Integer> operations = new HashMap<String, Integer>();
    static {
        operations.put("drivers", 1);
    }

    @Parameter(index=0)
    private String what;

    public ListCommand() {
        super("list");
    }

    @Override
    public int execute(Shell shell, BufferedReader in, PrintStream out) {
        Integer whatToDo = operations.get(what.toLowerCase());
        switch (whatToDo) {
            case 1:
                TableToStringRenderer renderer = new TableToStringRenderer(shell.getBorder());
                out.println(renderer.render(new ObjectCollectionDataModel(drivers.values(),
                        new ColumnDataModel<Driver>("Database Name") {
                            @Override
                            public String value(Driver driver) {
                                return driver.databaseName();
                            }
                        },
                        new ColumnDataModel<Driver>("Driver Available") {
                            @Override
                            public String value(Driver driver) {
                                return driver.isAvailable() ? "YES" : "NO";
                            }
                        },
                        new ColumnDataModel<Driver>("Supported Versions") {
                            @Override
                            public String value(Driver driver) {
                                return join(driver.supportedVersions());
                            }
                        },
                        new ColumnDataModel<Driver>("Website") {
                            @Override
                            public String value(Driver driver) {
                                return driver.databaseWebsite();
                            }
                        }
                )));
                break;
        }
        return 0;
    }

}
