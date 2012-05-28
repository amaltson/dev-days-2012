require 'rubygems'
require 'active_record'
require 'src/event'

dbLocation = 'dev-days.db'

ActiveRecord::Base.establish_connection(:adapter => "jdbcsqlite3", :dbfile  => dbLocation)

events = Event.all()

puts Event.inspect()

events.each { | eachEvent |
  puts eachEvent
}