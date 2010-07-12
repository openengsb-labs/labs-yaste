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
package org.openengsb.yaste.cli.commands;

import java.util.HashSet;
import java.util.Set;

import org.openengsb.yaste.cli.Console;
import org.openengsb.yaste.cli.TestProject;

public abstract class AbstractCommand implements Command {

    private final Set<String> names;

    public AbstractCommand() {
        names = new HashSet<String>();
    }

    protected void addName(String name) {
        names.add(name);
    }

    @Override
    public boolean matchesRequest(String request) {
        String[] s = request.split(" ");
        return s.length > 0 && names.contains(s[0]);
    }

    @Override
    public void run(String request, TestProject testProject, Console console) {
        if (!matchesRequest(request)) {
            throw new IllegalArgumentException("request does not match command");
        }
        runCommand(request, testProject, console);
    }

    protected abstract void runCommand(String request, TestProject testProject, Console console);
}
