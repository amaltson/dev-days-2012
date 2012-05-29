package com.otpp.ws.careerevent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.otpp.careerevent.CareerEventFacade;
import com.otpp.domain.date.Date;

@WebService(wsdlLocation = "WEB-INF/wsdl/CareerEventService.wsdl", endpointInterface = "com.otpp.ws.careerevent.CareerEventService", targetNamespace = "http://careerevent.ws.otpp.com/", serviceName = "CareerEvent", portName = "CareerEventWebService")
public class CareerEventServicePortBindingImpl implements CareerEventService {
	public String getVersion() {
		return "1.0.0-SNAPSHOT";
	}

	public List<AbsenceEvent> getAbsences(String irn, Epw arg1,
			XMLGregorianCalendar arg2, XMLGregorianCalendar arg3, int arg4) {
		
		CareerEventFacade facade = new CareerEventFacade();
		List<com.otpp.careerevent.events.AbsenceEvent> events = facade.getAbsences(irn);
		
		List<AbsenceEvent> wsEvents = new ArrayList<AbsenceEvent>();
		for (com.otpp.careerevent.events.AbsenceEvent event : events) {
			AbsenceEvent wsEvent = new AbsenceEvent();
			wsEvent.setEventId(event.getEventId());
			wsEvent.setEntityIrn(event.getEntityIrn().toString());
			wsEvent.setStartDate(dateToXmlGregorianCalendar(event.getStartDate()));
			wsEvent.setEndDate(dateToXmlGregorianCalendar(event.getEndDate()));
			
			Epw wsEpw = new Epw();
			wsEpw.setEmployerIrn(event.getEpw().getEmployerIrn().toString());
			wsEpw.setProfile(event.getEpw().getProfileCode().getProfileCode());
			wsEpw.setWorkCode(event.getWorkCode().getWorkcode());
			wsEvent.setEpw(wsEpw);
			
			wsEvent.setEventCode(event.getEventCode());
			wsEvents.add(wsEvent);
		}
		
		return wsEvents;
	}
	
	public XMLGregorianCalendar dateToXmlGregorianCalendar(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(date.getYear(), date.getMonthIndex() - 1, date.getDayOfMonth());
		XMLGregorianCalendar xmlCalendar = null;
		try {
			xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		return xmlCalendar;
	}
}
