require 'rubygems'
require 'java'

gem 'minitest'
require 'minitest/unit'
require 'src/CareerEventManager'

MiniTest::Unit.autorun

class CareerEventManagerTest < MiniTest::Unit::TestCase

  def testMapIrn
    # TODO Implement this test to verify the IRN String to domain IRN conversion method works
    # HINT: Look at the actual method 'mapIrn' in CareerEventManager.rb
    assert_nil(nil) # Remove this first
  end

  def testMapEpw
    careerEventManager = CareerEventManager.new
    testWsEpw = com.otpp.ws.careerevent.Epw.new
    testWsEpw.setEmployerIrn(java.lang.String.new('888888888'))
    testWsEpw.setProfile(java.lang.String.new('TEACH'))
    testWsEpw.setWorkCode(java.lang.Integer.new(1))
    domainEpw = careerEventManager.mapEpw(testWsEpw)
    assert_equal('888888888', domainEpw.getEmployerIrn.toString)
    assert_equal('TEACH', domainEpw.getProfileCode.toString)
    assert_equal('1', domainEpw.getWorkCode.toString)
  end

end