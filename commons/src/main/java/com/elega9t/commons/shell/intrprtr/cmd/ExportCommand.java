package com.elega9t.commons.shell.intrprtr.cmd;

import com.elega9t.commons.entity.DefaultEntity;
import com.elega9t.commons.shell.Shell;
import com.elega9t.commons.shell.intrprtr.Command;
import com.elega9t.commons.shell.intrprtr.Parameter;

public class ExportCommand extends DefaultEntity implements Command {

    @Parameter(index=0)
    private String what;

    public ExportCommand() {
        super("export");
    }

    @Override
    public int execute(Shell shell) {
        int separatorIndex = what.indexOf("=");
        if(separatorIndex != -1) {
            shell.getEnvironment().setProperty(what.substring(0, separatorIndex), what.substring(separatorIndex+1));
        }
        return 0;
    }

}
