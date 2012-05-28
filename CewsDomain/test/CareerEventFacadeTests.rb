Bundler.require

require 'minitest/autorun'
require 'java'
require 'src/CareerEventFacade'

java_import 'com.otpp.core.InternalReferenceNumber'
java_import 'com.otpp.careerevent.events.AbsenceEvent'

class CareerEventFacadeTests < MiniTest::Unit::TestCase
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
    date = javaDateFromInt(20081031)
    assert_equal '2008-10-31', date.to_s
  end
  
  def test_buildEpw
    irn = '123456789'
    profileCode = 'ABR'
    workCode = 10
    epw = buildEpw(irn, profileCode, workCode)
    assert_equal(irn, epw.getEmployerIrn.to_s)
    assert_equal(profileCode, epw.getProfileCode.getProfileCode)
    assert_equal(workCode, epw.getWorkCode.getWorkcode)
  end

  def test_getAbsences_fromDB_whereDBContainsData
    irn = '896163008'
    facade = CareerEventFacade.new
    absences = facade.getAbsences(irn)
    assert_equal(1, absences.length)
    absence = absences.fetch(0)
    assert_equal(irn, absence.getEntityIrn.to_s)
  end

  def test_getAbsences_fromDB_whereDBContainsNoData
    irn = '111111111'
    facade = CareerEventFacade.new
    absences = facade.getAbsences(irn)
    assert_equal(0, absences.length)
  end
end
