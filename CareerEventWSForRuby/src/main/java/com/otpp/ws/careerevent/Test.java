package com.otpp.ws.careerevent;

import java.util.List;

import com.otpp.careerevent.CareerEventFacade;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CareerEventFacade facade = new CareerEventFacade();
		List<com.otpp.careerevent.events.AbsenceEvent> event = facade.getAbsences("896163008");
		System.out.println(event.size());
	}
}
