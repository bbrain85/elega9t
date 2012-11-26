/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.cloudfoundry.cli.cmds;

import com.elega9t.commons.shell.Shell;
import com.elega9t.commons.shell.intrprtr.Command;
import com.elega9t.commons.shell.intrprtr.UnnamedParameter;
import org.cloudfoundry.client.lib.CloudFoundryClient;

public class RenameCommand extends Command {

    @UnnamedParameter(index=0)
    private String appName;

    @UnnamedParameter(index=1)
    private String newAppName;

    public RenameCommand() {
        super("rename");
    }

    @Override
    public int execute(Shell shell) {
        CloudFoundryClient client = (CloudFoundryClient) shell.getContextElement("cloudfoundry-client");
        client.rename(appName, newAppName);
        return 0;
    }

}
