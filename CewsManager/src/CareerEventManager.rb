# TODO uncomment this when trying bundler packaging again
#Bundler.require

require 'java'
java_package 'com.otpp.careerevent.manager'

#java_require 'CareerEventManager'

# TODO remove when using stripped down CewsServer
#require '/home/user/.m2/repository/otpp/ws/careerevent/CareerEventWSDL/2.3.5/CareerEventWSDL-2.3.5.jar' # CareerEvent, AbsenceFitleringType
#require '/home/user/.m2/repository/otpp/domain/com.otpp.domain.references/1.1.4/com.otpp.domain.references-1.1.4.jar'
#require '/home/user/.m2/repository/otpp/domain/com.otpp.domain.core/5.1.0/com.otpp.domain.core-5.1.0.jar' # EPW, InternalReferenceNumber
#require '/home/user/.m2/repository/otpp/domain/com.otpp.domain.careerevent/5.0.2/com.otpp.domain.careerevent-5.0.2.jar' # AbsenceEvent, EventAttribute, EventCustomer

# TODO use these w/ stripped down jars
require '/home/user/.m2/repository/otpp/devdays/com.otpp.devdays.careerevent/1.0.0-SNAPSHOT/com.otpp.devdays.careerevent-1.0.0-SNAPSHOT.jar'
require '/home/user/.m2/repository/otpp/devdays/otpp.devdays.ws.careerevent.CareerEventWSDL/1.0.0-SNAPSHOT/otpp.devdays.ws.careerevent.CareerEventWSDL-1.0.0-SNAPSHOT.jar'

java_import 'com.otpp.domain.employer.EPW' # TODO use w/ stripped down CewsServer
java_import 'com.otpp.core.InternalReferenceNumber'
java_import 'com.otpp.domain.date.Date'
#java_import 'com.otpp.domain.message.ProcessingMessageImpl'
java_import 'com.otpp.ws.careerevent.CareerEvent'
#java_import 'com.otpp.ws.careerevent.AbsenceFilteringType'
java_import 'com.otpp.careerevent.events.AbsenceEvent' # TODO use w/ stripped down CewsServer
#java_import 'com.otpp.domain.careerevent.events.AbsenceEvent'
java_import 'com.otpp.careerevent.events.EventAttribute' # TODO use w/ stripped down CewsServer
#java_import 'com.otpp.domain.careerevent.events.EventAttribute'
#java_import 'com.otpp.domain.careerevent.events.EventCustomer'
java_import 'java.net.URL'
java_import 'javax.xml.namespace.QName'

class CareerEventManager
  
  def initialize()
    wsdlUrl = java.net.URL.new('http://localhost:8080/services/CareerEventService?wsdl')
    qName = QName.new("http://careerevent.ws.otpp.com/", "CareerEvent")
    service = CareerEvent.new(wsdlUrl, qName)
    cews = service.getCareerEventWebService()
    @careerEventService = cews
  end

  # List<com.otpp.careerevent.events.AbsenceEvent> CareerEventManager.getAbsences(com.otpp.core.InternalReferenceNumber)
  java_signature 'java.util.List<com.otpp.careerevent.events.AbsenceEvent> getAbsences(com.otpp.core.InternalReferenceNumber)'
  def getAbsences(memberIrn)
#    wsAbsences = @careerEventService.getAbsences(memberIrn.toString, nil, nil, nil, 0, com.otpp.ws.careerevent.AbsenceFilteringType::NONE)
    wsAbsences = @careerEventService.getAbsences(memberIrn.toString, nil, nil, nil, 0) # TODO change back to this when using stripped down CewsServer
    mapAbsenceEvents(wsAbsences)
  end
  
#  private
    
    # List<com.otpp.careerevent.events.AbsenceEvent> CareerEventManager.mapAbsenceEvents(List<com.otpp.ws.careerevent.AbsenceEvent>)
    java_signature 'java.util.List<com.otpp.careerevent.events.AbsenceEvent> mapAbsenceEvents(java.util.List<com.otpp.ws.careerevent.AbsenceEvent>)'
    def mapAbsenceEvents(wsAbsences)
      domainAbsences = []
      wsAbsences.each { |wsAbsence|
        domainAbsences << mapAbsenceEvent(wsAbsence)
      }
      return domainAbsences
    end
    
    # com.otpp.careerevent.events.AbsenceEvent WebServiceToDomainMappings.mapAbsenceEvents(com.otpp.ws.careerevent.AbsenceEvent)
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
    
    # void WebServiceToDomainMappings.mapAbstractEvent(com.otpp.careerevent.events.AbsenceEvent, com.otpp.ws.careerevent.AbsenceEvent)
    java_signature 'void mapAbstractEvent(com.otpp.careerevent.events.AbsenceEvent, com.otpp.ws.careerevent.AbsenceEvent)'
    def mapAbstractEvent(domainAbsence, wsAbsence)
      domainAbsence.setChannel(wsAbsence.getChannel)
  #    domainAbsence.setCustomerType(wsAbsence.getCustomerType == nil ? nil : EventCustomer.valueOf(wsAbsence.getCustomerType))
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
      
  #    wsAbsence.getEventAttributes.each { |attribute|
  #      domainAbsence.getEventAttributes.put(attribute.getKey, EventAttribute.new(attribute.getKey, attribute.getTextValue, attribute.getNumericValue))
  #    }
      
  #    wsAbsence.getMessages.each { |message|
  #      domainAbsence.getMessages.add(ProcessingMessageImpl.new(message.getErrorMessage, message.getErrorString))
  #    }
    end
    
    # com.otpp.domain.date.Date WebServiceToDomainMappings.mapDate(javax.xml.datatype.XMLGregorianCalendar)
    java_signature 'com.otpp.domain.date.Date mapDate(javax.xml.datatype.XMLGregorianCalendar)'
    def mapDate(calendarDate)
      calendarDate == nil ? nil : Date.new(calendarDate.getYear, calendarDate.getMonth(), calendarDate.getDay)
    end
    
    # com.otpp.core.InternalReferenceNumber WebServiceToDomainMappings.mapIrn(String)
    java_signature 'com.otpp.core.InternalReferenceNumber mapIrn(java.lang.String)'
    def mapIrn(irnString)
      irnString == nil ? nil : InternalReferenceNumber.valueOf(irnString)
    end
    
    # com.otpp.domain.employer.EPW WebServiceToDomainMappings.mapEpw(com.otpp.ws.careerevent.Epw)
    java_signature 'com.otpp.domain.employer.EPW mapEpw(com.otpp.ws.careerevent.Epw)'
    def mapEpw(wsEpw)
      wsEpw == nil ? nil : EPW.new(wsEpw.getEmployerIrn, wsEpw.getProfile, wsEpw.getWorkCode)
    end
end

# TODO CEWS Viewer will do these steps, but in Java
# modify the careerEventSource @Bean method in Config.java in CEWS Viewer to do this
#careerEventManager = CareerEventManager.new
#myIrn = InternalReferenceNumber.valueOf('309576318')
#careerEventManager.getAbsences(myIrn).each { |absence|
#  puts absence.getStartDate
#}
