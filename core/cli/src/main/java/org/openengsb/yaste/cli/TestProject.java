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

import java.io.File;
import java.io.IOException;

public interface TestProject {
    /**
     * Returns true if the given file exists in the test directory.
     *
     * @throws IllegalArgumentException if the given path is not a relative path
     */
    public boolean doesFileExists(File file);

    /**
     * Writes the given {@code content} to the given file relative to the test
     * directory. Note, this overwrites an existing file.
     *
     * @throws IOException
     */
    public void writeFile(File file, String content) throws IOException;
}
