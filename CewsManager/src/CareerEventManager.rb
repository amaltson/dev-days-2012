Bundler.require

require 'java'
java_package 'com.otpp.careerevent.manager'

java_import 'com.otpp.domain.employer.EPW'
java_import 'com.otpp.core.InternalReferenceNumber'
java_import 'com.otpp.domain.date.Date'
java_import 'com.otpp.ws.careerevent.CareerEvent'
java_import 'com.otpp.careerevent.events.AbsenceEvent'
java_import 'com.otpp.careerevent.events.EventAttribute'
java_import 'java.net.URL'
java_import 'javax.xml.namespace.QName'

class CareerEventManager

  def initialize()
    wsdlUrl = java.net.URL.new('http://localhost:8080/services/CareerEventService?wsdl')
    qName = QName.new("http://careerevent.ws.otpp.com/", "CareerEvent")
    service = CareerEvent.new(wsdlUrl, qName)
    @careerEventService = service.getCareerEventWebService()
  end

  java_signature 'java.util.List<com.otpp.careerevent.events.AbsenceEvent> getAbsences(com.otpp.core.InternalReferenceNumber)'
  def getAbsences(memberIrn)
    wsAbsences = @careerEventService.getAbsences(memberIrn.toString, nil, nil, nil, 0)
    mapAbsenceEvents(wsAbsences)
  end

  java_signature 'java.util.List<com.otpp.careerevent.events.AbsenceEvent> mapAbsenceEvents(java.util.List<com.otpp.ws.careerevent.AbsenceEvent>)'
  def mapAbsenceEvents(wsAbsences)
    domainAbsences = []
    wsAbsences.each { |wsAbsence|
      domainAbsences << mapAbsenceEvent(wsAbsence)
    }
    return domainAbsences
  end

  java_signature 'com.otpp.careerevent.events.AbsenceEvent mapAbsenceEvents(com.otpp.ws.careerevent.AbsenceEvent)'
  def mapAbsenceEvent(wsAbsence)
    if !wsAbsence
      return nil
    end
    domainAbsence = AbsenceEvent.new
    domainAbsence.setLinkedBuybackId(wsAbsence.getLinkedPurchaseId)
    mapAbstractEvent(domainAbsence, wsAbsence)
    return domainAbsence
  end

  java_signature 'void mapAbstractEvent(com.otpp.careerevent.events.AbsenceEvent, com.otpp.ws.careerevent.AbsenceEvent)'
  def mapAbstractEvent(domainAbsence, wsAbsence)
    domainAbsence.setChannel(wsAbsence.getChannel)
    domainAbsence.setEndDate(mapDate(wsAbsence.getEndDate) == nil ? Date::FUTURE : mapDate(wsAbsence.getEndDate))
    domainAbsence.setEntityIrn(mapIrn(wsAbsence.getEntityIrn))
    domainAbsence.setEpw(mapEpw(wsAbsence.getEpw))
    domainAbsence.setEventCode(wsAbsence.getEventCode)
    domainAbsence.setEventId(wsAbsence.getEventId)
    domainAbsence.setIssue(wsAbsence.getIssue)
    domainAbsence.setMemberIrn(mapIrn(wsAbsence.getMemberIrn))
    domainAbsence.setOwner(wsAbsence.getOwner)
    domainAbsence.setReasonCode(wsAbsence.getReasonCode)
    domainAbsence.setSource(wsAbsence.getSource)
    domainAbsence.setStartDate(mapDate(wsAbsence.getStartDate) == nil ? Date::PAST : mapDate(wsAbsence.getStartDate))
    domainAbsence.setStatus(wsAbsence.getStatus)
  end

  java_signature 'com.otpp.domain.date.Date mapDate(javax.xml.datatype.XMLGregorianCalendar)'
  def mapDate(calendarDate)
    calendarDate == nil ? nil : Date.new(calendarDate.getYear, calendarDate.getMonth(), calendarDate.getDay)
  end

  java_signature 'com.otpp.core.InternalReferenceNumber mapIrn(java.lang.String)'
  def mapIrn(irnString)
    irnString == nil ? nil : InternalReferenceNumber.valueOf(irnString)
  end

  java_signature 'com.otpp.domain.employer.EPW mapEpw(com.otpp.ws.careerevent.Epw)'
  def mapEpw(wsEpw)
    wsEpw == nil ? nil : EPW.new(wsEpw.getEmployerIrn, wsEpw.getProfile, wsEpw.getWorkCode)
  end
end
