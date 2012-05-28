package com.otpp.ws.careerevent;

import java.util.List;

import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;

@WebService(wsdlLocation = "WEB-INF/wsdl/CareerEventService.wsdl", endpointInterface = "com.otpp.ws.careerevent.CareerEventService", targetNamespace = "http://careerevent.ws.otpp.com/", serviceName = "CareerEvent", portName = "CareerEventWebService")
public class CareerEventServicePortBindingImpl implements CareerEventService {
	public String getVersion() {
		return "1.0.0-SNAPSHOT";
	}

	public List<AbsenceEvent> getAbsences(String arg0, Epw arg1,
			XMLGregorianCalendar arg2, XMLGregorianCalendar arg3, int arg4) {
		return null;
	}
}
