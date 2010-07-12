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

import java.io.File;
import java.io.IOException;

import org.openengsb.yaste.cli.Console;
import org.openengsb.yaste.cli.TestProject;

public class InitCommand extends AbstractCommand {

    public InitCommand() {
        addName("init");
    }

    @Override
    public void runCommand(String request, TestProject testProject, Console console) {
        File projectFile = new File("yaste");
        if (testProject.doesFileExists(projectFile)) {
            console.writeError("A project file does already exist.");
            return;
        }
        String[] s = request.split("[ ]+");
        String name = s.length >= 2 ? s[1] : "";
        if (!name.matches("^[A-Za-z_-]*$")) {
            console.writeError("Invalid project name");
            return;
        }
        try {
            testProject.writeFile(projectFile, "set_name '" + name + "'");
            console.writeInfo("Created new test project.");
        } catch (IOException e) {
            throw new RuntimeException("Colud not create project file", e);
        }
    }
}
