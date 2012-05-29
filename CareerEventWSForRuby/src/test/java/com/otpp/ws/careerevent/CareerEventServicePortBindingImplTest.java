package com.otpp.ws.careerevent;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CareerEventServicePortBindingImplTest {

	private CareerEventServicePortBindingImpl careerEventService;
	
	@Before
	public void initBefore() {
		careerEventService = new CareerEventServicePortBindingImpl();
	}
	
	@Test
	public void testGetAbsences() {
		List<AbsenceEvent> events = careerEventService.getAbsences("896163008", null, null, null, 1);
		assertEquals(1, events.size());
	}
}
