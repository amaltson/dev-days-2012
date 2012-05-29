$LOAD_PATH << "gems/activemodel-3.2.3/lib"
$LOAD_PATH << "gems/activerecord-3.2.3/lib"
$LOAD_PATH << "gems/activerecord-jdbc-adapter-1.2.2/lib"
$LOAD_PATH << "gems/activerecord-jdbcsqlite3-adapter-1.2.2/lib"
$LOAD_PATH << "gems/activesupport-3.2.3/lib"
$LOAD_PATH << "gems/arel-3.0.2/lib"
$LOAD_PATH << "gems/builder-3.0.0/lib"
$LOAD_PATH << "gems/bundler-1.1.3/lib"
$LOAD_PATH << "gems/i18n-0.6.0/lib"
$LOAD_PATH << "gems/jbundler-0.0.1/lib"
$LOAD_PATH << "gems/jdbc-sqlite3-3.7.2/lib"
$LOAD_PATH << "gems/multi_json-1.3.5/lib"
$LOAD_PATH << "gems/rake-0.9.2.2/lib"
$LOAD_PATH << "gems/ruby-maven-3.0.3.0.29.0.pre/lib"
$LOAD_PATH << "gems/thor-0.14.6/lib"
$LOAD_PATH << "gems/tzinfo-0.3.33/lib"

require 'java'
require 'active_record'
require 'rubygems'
require 'src/event'

# Bundler.require

#java_require 'CareerEventFacade'

java_package 'com.otpp.careerevent'

java_import 'com.otpp.core.InternalReferenceNumber'
#java_import 'com.otpp.domain.date.Date'
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
    domainAbsences = dbAbsences.collect{|dbAbsence| self.buildAbsence(dbAbsence)}
    return domainAbsences
  end

  def getDbAbsences(irnString)
    allDbEvents = Event.all()
    matchedDbAbsences = allDbEvents.select {|event| event.legalEntityIrn.to_s.eql? irnString}
    return matchedDbAbsences
  end

  def buildAbsence(dbAbsence)
    absenceEvent = AbsenceEvent.new()

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

