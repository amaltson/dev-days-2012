/**
 * Attribute.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.otpp.ws.careerevent;

public class Attribute  implements java.io.Serializable {
    private java.lang.String key;

    private java.math.BigDecimal numericValue;

    private java.lang.String textValue;

    public Attribute() {
    }

    public Attribute(
           java.lang.String key,
           java.math.BigDecimal numericValue,
           java.lang.String textValue) {
           this.key = key;
           this.numericValue = numericValue;
           this.textValue = textValue;
    }


    /**
     * Gets the key value for this Attribute.
     * 
     * @return key
     */
    public java.lang.String getKey() {
        return key;
    }


    /**
     * Sets the key value for this Attribute.
     * 
     * @param key
     */
    public void setKey(java.lang.String key) {
        this.key = key;
    }


    /**
     * Gets the numericValue value for this Attribute.
     * 
     * @return numericValue
     */
    public java.math.BigDecimal getNumericValue() {
        return numericValue;
    }


    /**
     * Sets the numericValue value for this Attribute.
     * 
     * @param numericValue
     */
    public void setNumericValue(java.math.BigDecimal numericValue) {
        this.numericValue = numericValue;
    }


    /**
     * Gets the textValue value for this Attribute.
     * 
     * @return textValue
     */
    public java.lang.String getTextValue() {
        return textValue;
    }


    /**
     * Sets the textValue value for this Attribute.
     * 
     * @param textValue
     */
    public void setTextValue(java.lang.String textValue) {
        this.textValue = textValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Attribute)) return false;
        Attribute other = (Attribute) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.key==null && other.getKey()==null) || 
             (this.key!=null &&
              this.key.equals(other.getKey()))) &&
            ((this.numericValue==null && other.getNumericValue()==null) || 
             (this.numericValue!=null &&
              this.numericValue.equals(other.getNumericValue()))) &&
            ((this.textValue==null && other.getTextValue()==null) || 
             (this.textValue!=null &&
              this.textValue.equals(other.getTextValue())));
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
        if (getKey() != null) {
            _hashCode += getKey().hashCode();
        }
        if (getNumericValue() != null) {
            _hashCode += getNumericValue().hashCode();
        }
        if (getTextValue() != null) {
            _hashCode += getTextValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Attribute.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://careerevent.ws.otpp.com/", "attribute"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("key");
        elemField.setXmlName(new javax.xml.namespace.QName("", "key"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numericValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numericValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "textValue"));
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
