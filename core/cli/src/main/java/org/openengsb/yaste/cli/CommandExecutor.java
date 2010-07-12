/**

   Copyright 2010 OpenEngSB Division, Vienna University of Technology

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package org.openengsb.yaste.cli;

import java.util.ArrayList;

import org.openengsb.yaste.cli.commands.Command;
import org.openengsb.yaste.cli.commands.HelpCommand;

public class CommandExecutor {
    private Console console;
    private TestProject testProject;
    private ArrayList<Command> commands;

    public CommandExecutor() {
        createCommandList();
    }

    public void execute(String request) {
        Command cmd = findMatchingCommand(request);
        if (cmd == null) {
            console.writeError("Unknown command");
            return;
        }
        cmd.run(request, testProject, console);
    }

    private void createCommandList() {
        commands = new ArrayList<Command>();
        commands.add(new HelpCommand());
    }

    private Command findMatchingCommand(String request) {
        for (Command cmd : commands) {
            if (cmd.matchesRequest(request)) {
                return cmd;
            }
        }
        return null;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public void setTestProject(TestProject testProject) {
        this.testProject = testProject;
    }
}
