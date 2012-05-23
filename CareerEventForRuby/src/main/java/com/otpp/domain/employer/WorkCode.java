package com.otpp.domain.employer;

import java.io.Serializable;

/**
 * Wraps a workcode, which is used to identify groups of calendars, contracts, or teachers as a sub grouping of profile codes.
 */
public final class WorkCode implements Comparable<WorkCode>, Serializable {

    private static final long serialVersionUID = -7487463637397812693L;

    /**
     * Code for a hybrid calendar.
     */
    public final static WorkCode HYBRID = new WorkCode(0);

    /**
     * Code for a 10 month school year calendar, typically Sept - June.
     */
    public final static WorkCode TEN_MONTH = new WorkCode(10);

    /**
     * Convenient short hand for a 10 month school year calendar.
     */
    public final static WorkCode TEN = WorkCode.TEN_MONTH;

    /**
     * Code for a 12 month school year calendar, usually for employees in administrator roles.
     */
    public final static WorkCode TWELVE_MONTH = new WorkCode(12);

    /**
     * Convenient short hand for a 12 month school year calendar.
     */
    public final static WorkCode TWELVE = WorkCode.TWELVE_MONTH;

    private final int workcode;

    public WorkCode(int workcode) {
        this.workcode = workcode;
    }

    public static WorkCode valueOf(int workcode) {
        return new WorkCode(workcode);
    }

    public int getWorkcode() {
        return workcode;
    }

    @Override
    public String toString() {
        return String.valueOf(workcode);
    }

    public int compareTo(WorkCode o) {
        return Integer.valueOf(workcode).compareTo(o.workcode);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + workcode;
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
        WorkCode other = (WorkCode) obj;
        if (workcode != other.workcode) {
            return false;
        }
        return true;
    }

}
