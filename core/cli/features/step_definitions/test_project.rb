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

When /^I run the cli without any arguments$/ do
  $cli.execute('')
end

Then /^the help information should be shown$/ do
  $console.info[0].should include('USAGE')
end

Given /^I haven't created a test project$/ do
end

When /^I create a test project "([^"]*)"$/ do |name|
  $cli.execute("init #{name}")
end

Then /^a new project file with the project name "([^"]*)" is created$/ do |name|
  projectfile = File.new $current_dir.join('yaste')
  lines = projectfile.readlines.map { |x| x.chomp }
  lines.should include("set_name '#{name}'")
end

Then /^an error message should be shown, saying "([^"]*)"$/ do |message|
  $console.error.should include(message)
end
