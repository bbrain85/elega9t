/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.cloudfoundry.cli.cmds;

import com.elega9t.commons.entity.impl.DefaultEntity;
import com.elega9t.commons.shell.Shell;
import com.elega9t.commons.shell.intrprtr.Command;
import com.elega9t.commons.shell.intrprtr.Parameter;
import org.cloudfoundry.client.lib.CloudFoundryClient;

import java.io.BufferedReader;
import java.io.PrintStream;

public class LogsCommand extends DefaultEntity implements Command {

    @Parameter(index=0)
    private String appName;

    public LogsCommand() {
        super("logs");
    }

    @Override
    public int execute(Shell shell, BufferedReader in, PrintStream out) {
        CloudFoundryClient client = (CloudFoundryClient) shell.getContextElement("cloudfoundry-client");
        if(client == null) {
            throw new IllegalStateException("You haven't logged in to cloudfoundry yet.");
        }
        out.print(client.getFile(appName, 0, "logs/stderr.log"));
        out.print(client.getFile(appName, 0, "logs/stdout.log"));
        return 0;
    }

}
