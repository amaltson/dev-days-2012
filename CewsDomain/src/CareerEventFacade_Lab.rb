Bundler.require

require 'java'
# TODO 1: resolve the error because ruby can't find the active_record library'
require 'active_record'
require 'rubygems'
require 'src/event'

java_package 'com.otpp.careerevent'

java_import 'com.otpp.core.InternalReferenceNumber'
java_import 'com.otpp.careerevent.events.AbsenceEvent'
java_import 'com.otpp.careerevent.events.CareerEventType'
java_import 'com.otpp.domain.employer.EPW'
java_import 'com.otpp.domain.employer.ProfileCode'
java_import 'com.otpp.domain.employer.WorkCode'


class CareerEventFacade
  
  def initialize
    dbLocation = 'dev-days.db'
    ActiveRecord::Base.establish_connection(:adapter => "jdbcsqlite3", :dbfile  => dbLocation)
  end

  java_signature 'java.util.List<com.otpp.careerevent.events.AbsenceEvent> getAbsences(java.lang.String)'
  def getAbsences(irnString)
    dbAbsences = getDbAbsences(irnString)
    # TODO 4: Convert each dbAbsence into a domainAbsence
    domainAbsences = []
    return domainAbsences
  end

  def getDbAbsences(irnString)
    allDbEvents = Event.all()
    matchedDbAbsences = allDbEvents.select {|event| event.legalEntityIrn.to_s.eql? irnString}
    return matchedDbAbsences
  end

  def buildAbsence(dbAbsence)
    absenceEvent = AbsenceEvent.new
    absenceEvent.setEventId(dbAbsence.EVENT_ID)
    absenceEvent.setEntityIrn(InternalReferenceNumber.valueOf(dbAbsence.legalEntityIrn))
    absenceEvent.setStartDate(javaDateFromInt(dbAbsence.effectiveDate))
    absenceEvent.setEndDate(javaDateFromInt(dbAbsence.expiryDate))
    absenceEvent.setEpw(buildEpw(dbAbsence.employerIrn.to_s, dbAbsence.employerProfileId, dbAbsence.workCode))
    absenceEvent.setEventType(CareerEventType.valueOf('ABSENCE'))
    absenceEvent.setEventCode(dbAbsence.eventCode)
    return absenceEvent
  end

  def outputEvent(absenceEvent)
    # These are the outputs required for the CEWS Viewer
    puts "Member IRN: \t" + absenceEvent.getEntityIrn().toString()
    puts "EPW: \t\t" + absenceEvent.getEpw().toString()
    puts "Event ID: \t" + absenceEvent.getEventId().to_s()
    puts "Start Date: \t" + absenceEvent.getStartDate().toString()
    puts "End Date: \t" + absenceEvent.getEndDate().toString()
    puts "Event Type: \t" + absenceEvent.getEventType().toString()
    puts "Event Code: \t" + absenceEvent.getEventCode()
    puts "Event Type: \t" + absenceEvent.getLinkedBuybackId().to_s()
    puts "Event Type: \t" + absenceEvent.getPaymentExpiryDate().toString()
    puts "Event Type: \t" + absenceEvent.getPaymentExpiryNotificationDate().toString()
  end

  def javaDateFromInt(integerDate)
    return com.otpp.domain.date.Date.new(integerDate)
  end

  def buildEpw(irn, profileCode, workCode)
    e = InternalReferenceNumber.valueOf(irn)
    p = ProfileCode.new(profileCode)
    w = WorkCode.new(workCode)
    epw = EPW.new(e, p, w)
    return epw
  end
end

