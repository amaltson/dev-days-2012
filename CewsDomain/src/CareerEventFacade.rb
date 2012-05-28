Bundler.require

require 'java'
java_package 'com.otpp.careerevent'

java_import 'com.otpp.core.InternalReferenceNumber'
java_import 'com.otpp.domain.date.Date'
java_import 'com.otpp.careerevent.events.AbsenceEvent'
java_import 'com.otpp.careerevent.events.CareerEventType'
java_import 'com.otpp.domain.employer.EPW'
java_import 'com.otpp.domain.employer.ProfileCode'
java_import 'com.otpp.domain.employer.WorkCode'

class CareerEventFacade
  
  def getAbsences(irn)
    absenceArray = []
    dbAbsence = nil
    domainAbsence = self.buildAbsence(dbAbsence)
    absenceArray << domainAbsence
    return absenceArray
  end
  
  def buildAbsence(dbAbsence)
    absenceEvent = AbsenceEvent.new()
    
    absenceEvent.setEventId(123456)
    
    absenceEvent.setEntityIrn(InternalReferenceNumber.valueOf('301999333'))
    
    startDate = Date.new(2009, 1, 1)
    absenceEvent.setStartDate(startDate)
    
    endDate = Date.new(2009, 11, 25)
    absenceEvent.setEndDate(endDate)
    
    absenceEvent.setEpw(buildEpw('999999999', 'ABR', 10))
    
    absenceEvent.setEventType(CareerEventType.valueOf('ABSENCE'))
    
    absenceEvent.setEventCode('019')
    
    #absenceEvent.setCustomerType()
    return absenceEvent
  end

  def main()
    build
    outputEvent(absenceEvent)
  end

  def buildEpw(irn, profileCode, workCode)
    e = InternalReferenceNumber.valueOf(irn)
    p = ProfileCode.new(profileCode)
    w = WorkCode.new(workCode)
    epw = EPW.new(e, p, w)
    return epw
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
    #puts "Event Type: \t" + absenceEvent.getCustomerType()
    puts "Event Type: \t" + absenceEvent.getLinkedBuybackId().to_s()
    puts "Event Type: \t" + absenceEvent.getPaymentExpiryDate().toString()
    puts "Event Type: \t" + absenceEvent.getPaymentExpiryNotificationDate().toString()
  end
end
