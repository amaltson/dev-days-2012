/**
 * AbsenceEvent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.otpp.ws.careerevent;

public class AbsenceEvent  extends com.otpp.ws.careerevent.AbstractEvent  implements java.io.Serializable {
    private boolean expiredForBuyback;

    private java.lang.Integer linkedPurchaseId;

    public AbsenceEvent() {
    }

    public AbsenceEvent(
           java.lang.String channel,
           java.lang.String customerType,
           java.util.Date endDate,
           java.lang.String entityIrn,
           com.otpp.ws.careerevent.Epw epw,
           java.lang.String eventCode,
           int eventId,
           java.lang.String issue,
           com.otpp.ws.careerevent.Attribute[] eventAttributes,
           java.lang.String memberIrn,
           java.lang.String owner,
           java.lang.String reasonCode,
           java.math.BigDecimal sickDays,
           java.lang.String source,
           java.util.Date startDate,
           java.lang.String status,
           boolean expiredForBuyback,
           java.lang.Integer linkedPurchaseId) {
        super(
            channel,
            customerType,
            endDate,
            entityIrn,
            epw,
            eventCode,
            eventId,
            issue,
            eventAttributes,
            memberIrn,
            owner,
            reasonCode,
            sickDays,
            source,
            startDate,
            status);
        this.expiredForBuyback = expiredForBuyback;
        this.linkedPurchaseId = linkedPurchaseId;
    }


    /**
     * Gets the expiredForBuyback value for this AbsenceEvent.
     * 
     * @return expiredForBuyback
     */
    public boolean isExpiredForBuyback() {
        return expiredForBuyback;
    }


    /**
     * Sets the expiredForBuyback value for this AbsenceEvent.
     * 
     * @param expiredForBuyback
     */
    public void setExpiredForBuyback(boolean expiredForBuyback) {
        this.expiredForBuyback = expiredForBuyback;
    }


    /**
     * Gets the linkedPurchaseId value for this AbsenceEvent.
     * 
     * @return linkedPurchaseId
     */
    public java.lang.Integer getLinkedPurchaseId() {
        return linkedPurchaseId;
    }


    /**
     * Sets the linkedPurchaseId value for this AbsenceEvent.
     * 
     * @param linkedPurchaseId
     */
    public void setLinkedPurchaseId(java.lang.Integer linkedPurchaseId) {
        this.linkedPurchaseId = linkedPurchaseId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AbsenceEvent)) return false;
        AbsenceEvent other = (AbsenceEvent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.expiredForBuyback == other.isExpiredForBuyback() &&
            ((this.linkedPurchaseId==null && other.getLinkedPurchaseId()==null) || 
             (this.linkedPurchaseId!=null &&
              this.linkedPurchaseId.equals(other.getLinkedPurchaseId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        _hashCode += (isExpiredForBuyback() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getLinkedPurchaseId() != null) {
            _hashCode += getLinkedPurchaseId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AbsenceEvent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://careerevent.ws.otpp.com/", "absenceEvent"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expiredForBuyback");
        elemField.setXmlName(new javax.xml.namespace.QName("", "expiredForBuyback"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkedPurchaseId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "linkedPurchaseId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
