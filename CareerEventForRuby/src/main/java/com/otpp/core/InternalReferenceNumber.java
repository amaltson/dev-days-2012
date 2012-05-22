package com.otpp.core;

import java.io.Serializable;

public class InternalReferenceNumber implements Serializable, Comparable<InternalReferenceNumber> {

    private static final long serialVersionUID = 865915164052094709L;

    /**
     * The Ministry of Education's unique internal reference number. Used frequently when algorithms looking for a specific irn
     * is unsuccessful.
     */
    public static final String MINISTRY_OF_EDUCATION_IRN_STRING = "306530953";

    public static final InternalReferenceNumber MINISTRY_OF_EDUCATION = InternalReferenceNumber.valueOf(InternalReferenceNumber.MINISTRY_OF_EDUCATION_IRN_STRING);

    private String irn;

    private InternalReferenceNumber() {
        // prevent default construction
    }

    private InternalReferenceNumber(String irnString) {

        if (irnString == null) {
            throw new NullPointerException("Cannot create an IRN from null");
        }

        irn = irnString;

    }

    public static InternalReferenceNumber valueOf(String irnString) {
        InternalReferenceNumber keyIrn = new InternalReferenceNumber(irnString);
        return keyIrn;
    }

    public static InternalReferenceNumber newInstance(String identifierString) {
        return new InternalReferenceNumber(identifierString);
    }

    public boolean isValid() {
        return true;
    }

    @Override
    public String toString() {
        return irn;
    }

    public int compareTo(InternalReferenceNumber o) {
        return irn.compareTo(o.irn);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + (irn == null ? 0 : irn.hashCode());
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
        InternalReferenceNumber other = (InternalReferenceNumber) obj;
        if (irn == null) {
            if (other.irn != null) {
                return false;
            }
        }
        else if (!irn.equals(other.irn)) {
            return false;
        }
        return true;
    }

}
