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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TestProjectTest {

    private final TemporaryFolder folder = new TemporaryFolder();
    private TestProject tp;

    @Before
    public void setup() throws IOException {
        folder.create();
        FileUtils.copyDirectory(new File(ClassLoader.getSystemResource("test-project").getPath()), folder.getRoot());
        tp = new TestProjectImpl(folder.getRoot());
    }

    @After
    public void teardown() {
        folder.delete();
    }

    @Test(expected = IllegalArgumentException.class)
    public void doesFileExist_nonRelativePath_throwsIAE() {
        tp.doesFileExists(new File(System.getProperty("user.dir")).getAbsoluteFile());
    }

    @Test
    public void doesFileExist_existingFile_shouldReturnTrue() {
        assertThat(tp.doesFileExists(new File("empty-file")), is(true));
    }
}
