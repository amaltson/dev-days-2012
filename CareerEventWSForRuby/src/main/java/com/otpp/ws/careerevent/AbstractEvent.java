/**
 * AbstractEvent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.otpp.ws.careerevent;

public abstract class AbstractEvent  implements java.io.Serializable {
    private java.lang.String channel;

    private java.lang.String customerType;

    private java.util.Date endDate;

    private java.lang.String entityIrn;

    private com.otpp.ws.careerevent.Epw epw;

    private java.lang.String eventCode;

    private int eventId;

    private java.lang.String issue;

    private com.otpp.ws.careerevent.Attribute[] eventAttributes;

    private java.lang.String memberIrn;

    private java.lang.String owner;

    private java.lang.String reasonCode;

    private java.math.BigDecimal sickDays;

    private java.lang.String source;

    private java.util.Date startDate;

    private java.lang.String status;

    public AbstractEvent() {
    }

    public AbstractEvent(
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
           java.lang.String status) {
           this.channel = channel;
           this.customerType = customerType;
           this.endDate = endDate;
           this.entityIrn = entityIrn;
           this.epw = epw;
           this.eventCode = eventCode;
           this.eventId = eventId;
           this.issue = issue;
           this.eventAttributes = eventAttributes;
           this.memberIrn = memberIrn;
           this.owner = owner;
           this.reasonCode = reasonCode;
           this.sickDays = sickDays;
           this.source = source;
           this.startDate = startDate;
           this.status = status;
    }


    /**
     * Gets the channel value for this AbstractEvent.
     * 
     * @return channel
     */
    public java.lang.String getChannel() {
        return channel;
    }


    /**
     * Sets the channel value for this AbstractEvent.
     * 
     * @param channel
     */
    public void setChannel(java.lang.String channel) {
        this.channel = channel;
    }


    /**
     * Gets the customerType value for this AbstractEvent.
     * 
     * @return customerType
     */
    public java.lang.String getCustomerType() {
        return customerType;
    }


    /**
     * Sets the customerType value for this AbstractEvent.
     * 
     * @param customerType
     */
    public void setCustomerType(java.lang.String customerType) {
        this.customerType = customerType;
    }


    /**
     * Gets the endDate value for this AbstractEvent.
     * 
     * @return endDate
     */
    public java.util.Date getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this AbstractEvent.
     * 
     * @param endDate
     */
    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the entityIrn value for this AbstractEvent.
     * 
     * @return entityIrn
     */
    public java.lang.String getEntityIrn() {
        return entityIrn;
    }


    /**
     * Sets the entityIrn value for this AbstractEvent.
     * 
     * @param entityIrn
     */
    public void setEntityIrn(java.lang.String entityIrn) {
        this.entityIrn = entityIrn;
    }


    /**
     * Gets the epw value for this AbstractEvent.
     * 
     * @return epw
     */
    public com.otpp.ws.careerevent.Epw getEpw() {
        return epw;
    }


    /**
     * Sets the epw value for this AbstractEvent.
     * 
     * @param epw
     */
    public void setEpw(com.otpp.ws.careerevent.Epw epw) {
        this.epw = epw;
    }


    /**
     * Gets the eventCode value for this AbstractEvent.
     * 
     * @return eventCode
     */
    public java.lang.String getEventCode() {
        return eventCode;
    }


    /**
     * Sets the eventCode value for this AbstractEvent.
     * 
     * @param eventCode
     */
    public void setEventCode(java.lang.String eventCode) {
        this.eventCode = eventCode;
    }


    /**
     * Gets the eventId value for this AbstractEvent.
     * 
     * @return eventId
     */
    public int getEventId() {
        return eventId;
    }


    /**
     * Sets the eventId value for this AbstractEvent.
     * 
     * @param eventId
     */
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }


    /**
     * Gets the issue value for this AbstractEvent.
     * 
     * @return issue
     */
    public java.lang.String getIssue() {
        return issue;
    }


    /**
     * Sets the issue value for this AbstractEvent.
     * 
     * @param issue
     */
    public void setIssue(java.lang.String issue) {
        this.issue = issue;
    }


    /**
     * Gets the eventAttributes value for this AbstractEvent.
     * 
     * @return eventAttributes
     */
    public com.otpp.ws.careerevent.Attribute[] getEventAttributes() {
        return eventAttributes;
    }


    /**
     * Sets the eventAttributes value for this AbstractEvent.
     * 
     * @param eventAttributes
     */
    public void setEventAttributes(com.otpp.ws.careerevent.Attribute[] eventAttributes) {
        this.eventAttributes = eventAttributes;
    }

    public com.otpp.ws.careerevent.Attribute getEventAttributes(int i) {
        return this.eventAttributes[i];
    }

    public void setEventAttributes(int i, com.otpp.ws.careerevent.Attribute _value) {
        this.eventAttributes[i] = _value;
    }


    /**
     * Gets the memberIrn value for this AbstractEvent.
     * 
     * @return memberIrn
     */
    public java.lang.String getMemberIrn() {
        return memberIrn;
    }


    /**
     * Sets the memberIrn value for this AbstractEvent.
     * 
     * @param memberIrn
     */
    public void setMemberIrn(java.lang.String memberIrn) {
        this.memberIrn = memberIrn;
    }


    /**
     * Gets the owner value for this AbstractEvent.
     * 
     * @return owner
     */
    public java.lang.String getOwner() {
        return owner;
    }


    /**
     * Sets the owner value for this AbstractEvent.
     * 
     * @param owner
     */
    public void setOwner(java.lang.String owner) {
        this.owner = owner;
    }


    /**
     * Gets the reasonCode value for this AbstractEvent.
     * 
     * @return reasonCode
     */
    public java.lang.String getReasonCode() {
        return reasonCode;
    }


    /**
     * Sets the reasonCode value for this AbstractEvent.
     * 
     * @param reasonCode
     */
    public void setReasonCode(java.lang.String reasonCode) {
        this.reasonCode = reasonCode;
    }


    /**
     * Gets the sickDays value for this AbstractEvent.
     * 
     * @return sickDays
     */
    public java.math.BigDecimal getSickDays() {
        return sickDays;
    }


    /**
     * Sets the sickDays value for this AbstractEvent.
     * 
     * @param sickDays
     */
    public void setSickDays(java.math.BigDecimal sickDays) {
        this.sickDays = sickDays;
    }


    /**
     * Gets the source value for this AbstractEvent.
     * 
     * @return source
     */
    public java.lang.String getSource() {
        return source;
    }


    /**
     * Sets the source value for this AbstractEvent.
     * 
     * @param source
     */
    public void setSource(java.lang.String source) {
        this.source = source;
    }


    /**
     * Gets the startDate value for this AbstractEvent.
     * 
     * @return startDate
     */
    public java.util.Date getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this AbstractEvent.
     * 
     * @param startDate
     */
    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }


    /**
     * Gets the status value for this AbstractEvent.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this AbstractEvent.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AbstractEvent)) return false;
        AbstractEvent other = (AbstractEvent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.channel==null && other.getChannel()==null) || 
             (this.channel!=null &&
              this.channel.equals(other.getChannel()))) &&
            ((this.customerType==null && other.getCustomerType()==null) || 
             (this.customerType!=null &&
              this.customerType.equals(other.getCustomerType()))) &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            ((this.entityIrn==null && other.getEntityIrn()==null) || 
             (this.entityIrn!=null &&
              this.entityIrn.equals(other.getEntityIrn()))) &&
            ((this.epw==null && other.getEpw()==null) || 
             (this.epw!=null &&
              this.epw.equals(other.getEpw()))) &&
            ((this.eventCode==null && other.getEventCode()==null) || 
             (this.eventCode!=null &&
              this.eventCode.equals(other.getEventCode()))) &&
            this.eventId == other.getEventId() &&
            ((this.issue==null && other.getIssue()==null) || 
             (this.issue!=null &&
              this.issue.equals(other.getIssue()))) &&
            ((this.eventAttributes==null && other.getEventAttributes()==null) || 
             (this.eventAttributes!=null &&
              java.util.Arrays.equals(this.eventAttributes, other.getEventAttributes()))) &&
            ((this.memberIrn==null && other.getMemberIrn()==null) || 
             (this.memberIrn!=null &&
              this.memberIrn.equals(other.getMemberIrn()))) &&
            ((this.owner==null && other.getOwner()==null) || 
             (this.owner!=null &&
              this.owner.equals(other.getOwner()))) &&
            ((this.reasonCode==null && other.getReasonCode()==null) || 
             (this.reasonCode!=null &&
              this.reasonCode.equals(other.getReasonCode()))) &&
            ((this.sickDays==null && other.getSickDays()==null) || 
             (this.sickDays!=null &&
              this.sickDays.equals(other.getSickDays()))) &&
            ((this.source==null && other.getSource()==null) || 
             (this.source!=null &&
              this.source.equals(other.getSource()))) &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getChannel() != null) {
            _hashCode += getChannel().hashCode();
        }
        if (getCustomerType() != null) {
            _hashCode += getCustomerType().hashCode();
        }
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        if (getEntityIrn() != null) {
            _hashCode += getEntityIrn().hashCode();
        }
        if (getEpw() != null) {
            _hashCode += getEpw().hashCode();
        }
        if (getEventCode() != null) {
            _hashCode += getEventCode().hashCode();
        }
        _hashCode += getEventId();
        if (getIssue() != null) {
            _hashCode += getIssue().hashCode();
        }
        if (getEventAttributes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEventAttributes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEventAttributes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMemberIrn() != null) {
            _hashCode += getMemberIrn().hashCode();
        }
        if (getOwner() != null) {
            _hashCode += getOwner().hashCode();
        }
        if (getReasonCode() != null) {
            _hashCode += getReasonCode().hashCode();
        }
        if (getSickDays() != null) {
            _hashCode += getSickDays().hashCode();
        }
        if (getSource() != null) {
            _hashCode += getSource().hashCode();
        }
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AbstractEvent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://careerevent.ws.otpp.com/", "abstractEvent"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("channel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "channel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entityIrn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "entityIrn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("epw");
        elemField.setXmlName(new javax.xml.namespace.QName("", "epw"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://careerevent.ws.otpp.com/", "epw"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eventCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eventId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "issue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventAttributes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eventAttributes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://careerevent.ws.otpp.com/", "attribute"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberIrn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memberIrn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("owner");
        elemField.setXmlName(new javax.xml.namespace.QName("", "owner"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reasonCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reasonCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sickDays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sickDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("source");
        elemField.setXmlName(new javax.xml.namespace.QName("", "source"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
