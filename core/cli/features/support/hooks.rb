#
#   Copyright 2010 OpenEngSB Division, Vienna University of Technology
#
#   Licensed under the Apache License, Version 2.0 (the "License");
#   you may not use this file except in compliance with the License.
#   You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.
#
require 'tmpdir'
require 'fileutils'
require 'pathname'

java_import 'org.openengsb.yaste.cli.CommandExecutor'
java_import 'org.openengsb.yaste.cli.Console'
java_import 'org.openengsb.yaste.cli.TestProjectImpl'

Around do |scenario, block|
  $current_dir = Pathname.new(Dir.mktmpdir)
  $cli = CommandExecutor.new
  $console = ConsoleMock.new
  $cli.set_console($console)
  $cli.set_test_project(TestProjectImpl.new(java.io.File.new($current_dir.to_s))
  block.call
  #FileUtils.rm_r($current_dir)
end

class ConsoleMock
  include Console
  
  attr_reader :error, :info
  
  def initialize()
    @info = []
    @error = []
  end
  
  def writeInfo(msg)
    @info << msg
  end
  
  def writeError(msg)
    @error << msg
  end
end