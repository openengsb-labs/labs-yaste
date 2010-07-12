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

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openengsb.yaste.cli.Console;
import org.openengsb.yaste.cli.TestProject;

public class InitCommandTest {

    @Test
    public void run_WithoutArgument_shouldWriteInitialProjectFile() throws IOException {
        TestProject testProject = mock(TestProject.class);
        when(testProject.doesFileExists(any(File.class))).thenReturn(false);
        new InitCommand().run("init", testProject, mock(Console.class));
        verify(testProject).writeFile(eq(new File("yaste")), anyString());
    }
}
