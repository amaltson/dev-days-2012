Bundler.require

require 'minitest/autorun'
require 'java'

java_import 'com.otpp.core.InternalReferenceNumber'
java_import 'com.otpp.careerevent.events.AbsenceEvent'

class CallCewsJar < MiniTest::Unit::TestCase
  def test_creating_absence_event
    absence = AbsenceEvent.new
    assert_equal nil, absence.event_id
    assert_equal nil, absence.event_type
    assert_equal nil, absence.member_irn
  end

  def test_creating_irn

    irn = InternalReferenceNumber.value_of '123456789'
    assert_equal true, irn.valid?
    assert_equal '123456789', irn.to_s
  end

  def test_creating_date
    date = com.otpp.domain.date.Date.new(20101010)
    assert_equal '2010-10-10', date.to_s
  end
end
