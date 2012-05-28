/**
 * CareerEventService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.otpp.ws.careerevent;

public interface CareerEventService extends java.rmi.Remote {
    public java.lang.String getVersion() throws java.rmi.RemoteException;
    public com.otpp.ws.careerevent.AbsenceEvent[] getAbsences(java.lang.String memberIrn, com.otpp.ws.careerevent.Epw epw, java.util.Date startDate, java.util.Date endDate, int schoolYear) throws java.rmi.RemoteException;
}
