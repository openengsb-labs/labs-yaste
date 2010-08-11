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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;
import org.openengsb.yaste.cli.Console;
import org.openengsb.yaste.cli.TestProject;

public class HelpCommandTest {
    @Test(expected = IllegalArgumentException.class)
    public void run_nonMatchingRequest_shouldThrowIAE() {
        new HelpCommand().run("a", mock(TestProject.class), mock(Console.class));
    }

    @Test
    public void run_matchinRequest_shouldPrintUsage() {
        Console c = mock(Console.class);
        new HelpCommand().run("help", mock(TestProject.class), c);
        verify(c).writeInfo(Mockito.contains("USAGE"));
    }
}
