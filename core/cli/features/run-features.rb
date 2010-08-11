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
require 'rubygems'
require 'cucumber/rspec/disable_option_parser'
require 'cucumber/cli/main'

begin
  return ! Cucumber::Cli::Main.execute(ARGV.dup)
rescue SystemExit => e
  STDERR.puts(e)
rescue Exception => e
  STDERR.puts("#{e.message} (#{e.class})")
  STDERR.puts(e.backtrace.join("\n"))
end

return false