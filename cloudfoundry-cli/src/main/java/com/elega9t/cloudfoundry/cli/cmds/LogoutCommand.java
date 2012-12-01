/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.cloudfoundry.cli.cmds;

import com.elega9t.commons.entity.DefaultEntity;
import com.elega9t.commons.shell.Shell;
import com.elega9t.commons.shell.intrprtr.Command;
import org.cloudfoundry.client.lib.CloudFoundryClient;

import java.net.URL;

public class LogoutCommand extends DefaultEntity implements Command {

    public LogoutCommand() {
        super("logout");
    }

    @Override
    public int execute(Shell shell) {
        URL target = (URL) shell.getContextElement("cloudfoundry-target");
        CloudFoundryClient client = (CloudFoundryClient) shell.getContextElement("cloudfoundry-client");
        if(client == null) {
            throw new IllegalStateException("You haven't logged in to cloudfoundry yet.");
        }
        client.logout();
        shell.outln("Successfully logged out from [" + target + "]");
        return 0;
    }

}
