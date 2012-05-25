Bundler.require

require 'java'

java_require 'CareerEventManager'

# TODO use derek's stripped down jars instead of these
#require 'dependencies/CareerEventWSDL-2.3.5.jar' # CareerEvent, AbsenceFitleringType
#require 'dependencies/com.otpp.domain.references-1.1.9.jar' #
#require 'dependencies/com.otpp.domain.core-5.1.0.jar' # EPW, InternalReferenceNumber
#require 'dependencies/com.otpp.domain.careerevent-5.0.2.jar' # AbsenceEvent, EventAttribute, EventCustomer
java_import com.otpp.domain.employer.EPW
java_import com.otpp.core.InternalReferenceNumber
java_import com.otpp.domain.date.Date
#java_import com.otpp.domain.message.ProcessingMessageImpl;
java_import com.otpp.ws.careerevent.CareerEvent
#java_import com.otpp.ws.careerevent.AbsenceFilteringType;
java_import com.otpp.careerevent.events.AbsenceEvent
java_import com.otpp.careerevent.events.EventAttribute
#java_import com.otpp.domain.careerevent.events.EventCustomer;
java_import java.net.URL
java_import javax.xml.namespace.QName

class CareerEventManager
  
  def initialize()
    wsdlUrl = java.net.URL.new('http://wasdev0/CareerEventWS/CareerEvent?wsdl') # this will be deployed as a local WS at dev days in VM, strip the wsdl down to just getAbsences before checking it, derek did it?
    qName = QName.new("http://careerevent.ws.otpp.com/", "CareerEvent")
    service = CareerEvent.new(wsdlUrl, qName)
    cews = service.getCareerEventWebService()
    @careerEventService = cews
  end

  # List<com.otpp.domain.careerevent.events.AbsenceEvent> CareerEventManager.getAbsences(com.otpp.core.InternalReferenceNumber)
  java_signature 'List<com.otpp.domain.careerevent.events.AbsenceEvent> getAbsences(com.otpp.core.InternalReferenceNumber)'
  def getAbsences(memberIrn)
#    wsAbsences = @careerEventService.getAbsences(memberIrn.toString, nil, nil, nil, 0, AbsenceFilteringType::NONE)
    wsAbsences = @careerEventService.getAbsences(memberIrn.toString, nil, nil, nil, 0)
    mapAbsenceEvents(wsAbsences)
  end
  
  # List<com.otpp.domain.careerevent.events.AbsenceEvent> CareerEventManager.mapAbsenceEvents(List<com.otpp.ws.careerevent.AbsenceEvent>)
  def mapAbsenceEvents(wsAbsences)
    domainAbsences = []
    wsAbsences.each { |wsAbsence|
      domainAbsences << mapAbsenceEvent(wsAbsence)
    }
    return domainAbsences
  end
  
  # com.otpp.domain.careerevent.events.AbsenceEvent WebServiceToDomainMappings.mapAbsenceEvents(com.otpp.ws.careerevent.AbsenceEvent)
  def mapAbsenceEvent(wsAbsence)
    if !wsAbsence
      return nil
    end
    domainAbsence = AbsenceEvent.new
    domainAbsence.setLinkedBuybackId(wsAbsence.getLinkedPurchaseId)
    mapAbstractEvent(domainAbsence, wsAbsence)
    return domainAbsence
  end
  
  # void WebServiceToDomainMappings.mapAbstractEvent(com.otpp.domain.careerevent.events.AbsenceEvent, com.otpp.ws.careerevent.AbsenceEvent)
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
  def mapDate(calendarDate)
    calendarDate == nil ? nil : Date.new(calendarDate.getYear, calendarDate.getMonth(), calendarDate.getDay)
  end
  
  # com.otpp.core.InternalReferenceNumber WebServiceToDomainMappings.mapIrn(String)
  def mapIrn(irnString)
    irnString == nil ? nil : InternalReferenceNumber.valueOf(irnString)
  end
  
  # com.otpp.domain.employer.EPW WebServiceToDomainMappings.mapEpw(com.otpp.ws.careerevent.Epw)
  def mapEpw(wsEpw)
    wsEpw == nil ? nil : EPW.new(wsEpw.getEmployerIrn, wsEpw.getProfile, wsEpw.getWorkCode)
  end
  
end

# TODO CEWS Viewer will do these steps, but in Java
# modify the careerEventSource @Bean method in Config.java in CEWS Viewer to do this
careerEventManager = CareerEventManager.new
myIrn = InternalReferenceNumber.valueOf('309576318')
careerEventManager.getAbsences(myIrn).each { |absence|
  puts absence.getStartDate
}