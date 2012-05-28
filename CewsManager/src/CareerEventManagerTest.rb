# README
# 1. 'sudo gem install minitest' to install MiniTest
# 2. Run as a ruby script or ruby test

require 'rubygems'
require 'java'

gem 'minitest'
require 'minitest/unit'
require 'src/CareerEventManager.rb'

MiniTest::Unit.autorun

class CareerEventManagerTest < MiniTest::Unit::TestCase
  def testMyMethod
    assert_equal 'foo', 'bar'
  end
  
  def testMapIrn
    cem = CareerEventManager.new
    assert_equal(InternalReferenceNumber.valueOf('888888888'), cem.mapIrn(java.lang.String.new('888888888')))
  end
  
end