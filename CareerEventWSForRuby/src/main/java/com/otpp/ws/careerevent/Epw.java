/**
 * Epw.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.otpp.ws.careerevent;

public class Epw  implements java.io.Serializable {
    private java.lang.String employerIrn;

    private java.lang.String profile;

    private java.lang.Integer workCode;

    public Epw() {
    }

    public Epw(
           java.lang.String employerIrn,
           java.lang.String profile,
           java.lang.Integer workCode) {
           this.employerIrn = employerIrn;
           this.profile = profile;
           this.workCode = workCode;
    }


    /**
     * Gets the employerIrn value for this Epw.
     * 
     * @return employerIrn
     */
    public java.lang.String getEmployerIrn() {
        return employerIrn;
    }


    /**
     * Sets the employerIrn value for this Epw.
     * 
     * @param employerIrn
     */
    public void setEmployerIrn(java.lang.String employerIrn) {
        this.employerIrn = employerIrn;
    }


    /**
     * Gets the profile value for this Epw.
     * 
     * @return profile
     */
    public java.lang.String getProfile() {
        return profile;
    }


    /**
     * Sets the profile value for this Epw.
     * 
     * @param profile
     */
    public void setProfile(java.lang.String profile) {
        this.profile = profile;
    }


    /**
     * Gets the workCode value for this Epw.
     * 
     * @return workCode
     */
    public java.lang.Integer getWorkCode() {
        return workCode;
    }


    /**
     * Sets the workCode value for this Epw.
     * 
     * @param workCode
     */
    public void setWorkCode(java.lang.Integer workCode) {
        this.workCode = workCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Epw)) return false;
        Epw other = (Epw) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.employerIrn==null && other.getEmployerIrn()==null) || 
             (this.employerIrn!=null &&
              this.employerIrn.equals(other.getEmployerIrn()))) &&
            ((this.profile==null && other.getProfile()==null) || 
             (this.profile!=null &&
              this.profile.equals(other.getProfile()))) &&
            ((this.workCode==null && other.getWorkCode()==null) || 
             (this.workCode!=null &&
              this.workCode.equals(other.getWorkCode())));
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
        if (getEmployerIrn() != null) {
            _hashCode += getEmployerIrn().hashCode();
        }
        if (getProfile() != null) {
            _hashCode += getProfile().hashCode();
        }
        if (getWorkCode() != null) {
            _hashCode += getWorkCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Epw.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://careerevent.ws.otpp.com/", "epw"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employerIrn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "employerIrn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "profile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "workCode"));
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
