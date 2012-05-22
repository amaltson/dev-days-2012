package com.otpp.careerevent.events;

import java.io.Serializable;
import java.math.BigDecimal;

public class EventAttribute implements Serializable {

    private static final long serialVersionUID = -8163041399139974291L;

    private String key;
    private BigDecimal numericValue;
    private String textValue;

    public EventAttribute(String key, String textValue, BigDecimal numericValue) {
        this.key = key;
        this.textValue = textValue;
        this.numericValue = numericValue;
    }

    public EventAttribute(EventAttribute copy) {
        key = copy.key;
        textValue = copy.textValue;
        numericValue = copy.numericValue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public BigDecimal getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(BigDecimal numeric) {
        numericValue = numeric;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String text) {
        textValue = text;
    }

    @Override
    public String toString() {
        String value = numericValue != null ? numericValue.toString() : textValue;
        return key + ":" + value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((numericValue == null) ? 0 : numericValue.hashCode());
        result = prime * result + ((textValue == null) ? 0 : textValue.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        EventAttribute other = (EventAttribute) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        }
        else if (!key.equals(other.key)) {
            return false;
        }
        if (numericValue == null) {
            if (other.numericValue != null) {
                return false;
            }
        }
        else if (numericValue.compareTo(other.numericValue) != 0) {
            return false;
        }
        if (textValue == null) {
            if (other.textValue != null) {
                return false;
            }
        }
        else if (!textValue.equals(other.textValue)) {
            return false;
        }
        return true;
    }
}
