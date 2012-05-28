/**
 * CareerEventServicePortBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.otpp.ws.careerevent;

public class CareerEventServicePortBindingSkeleton implements com.otpp.ws.careerevent.CareerEventService, org.apache.axis.wsdl.Skeleton {
    private com.otpp.ws.careerevent.CareerEventService impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
        };
        _oper = new org.apache.axis.description.OperationDesc("getVersion", _params, new javax.xml.namespace.QName("", "return"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://careerevent.ws.otpp.com/", "getVersion"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getVersion") == null) {
            _myOperations.put("getVersion", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getVersion")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "memberIrn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "epw"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://careerevent.ws.otpp.com/", "epw"), com.otpp.ws.careerevent.Epw.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "startDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"), java.util.Date.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "endDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"), java.util.Date.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "schoolYear"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getAbsences", _params, new javax.xml.namespace.QName("", "return"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://careerevent.ws.otpp.com/", "absenceEvent"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://careerevent.ws.otpp.com/", "getAbsences"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getAbsences") == null) {
            _myOperations.put("getAbsences", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getAbsences")).add(_oper);
    }

    public CareerEventServicePortBindingSkeleton() {
        this.impl = new com.otpp.ws.careerevent.CareerEventServicePortBindingImpl();
    }

    public CareerEventServicePortBindingSkeleton(com.otpp.ws.careerevent.CareerEventService impl) {
        this.impl = impl;
    }
    public java.lang.String getVersion() throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getVersion();
        return ret;
    }

    public com.otpp.ws.careerevent.AbsenceEvent[] getAbsences(java.lang.String memberIrn, com.otpp.ws.careerevent.Epw epw, java.util.Date startDate, java.util.Date endDate, int schoolYear) throws java.rmi.RemoteException
    {
        com.otpp.ws.careerevent.AbsenceEvent[] ret = impl.getAbsences(memberIrn, epw, startDate, endDate, schoolYear);
        return ret;
    }

}
