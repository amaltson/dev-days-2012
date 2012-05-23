package com.otpp.domain.employer;

import java.io.Serializable;

import com.otpp.core.InternalReferenceNumber;

/**
 * E(mployer Irn) P(rofile) W(orkcode)
 * 
 * A basic unit of information that can be used, along with amember's IRN to access contract information. Mostly a convenience grouping
 * since the concepts are so frequently used together (as EPW)
 */
public final class EPW implements Comparable<EPW>, Serializable {

    private static final long serialVersionUID = -9197962585635939502L;
    private final InternalReferenceNumber employerIrn;
    private ProfileCode profileCode = null;
    private WorkCode workCode = null;

    /**
     * Standard Copy constructor
     */
    public EPW(EPW copy) {
        employerIrn = copy.employerIrn;
        profileCode = copy.profileCode;
        workCode = copy.workCode;
    }

    public EPW(InternalReferenceNumber employerIrn) {
        if (employerIrn == null) {
            throw new NullPointerException("Should not have a null employer");
        }

        this.employerIrn = employerIrn;
    }

    public EPW(InternalReferenceNumber employerIrn, ProfileCode profile, WorkCode workcode) {

        if (employerIrn == null) {
            throw new NullPointerException("Should not have a null employer");
        }

        this.employerIrn = employerIrn;

        if (((profile == null) && (workcode != null)) || ((workcode == null) && (profile != null))) {
            throw new NullPointerException("Profile and workcode should both be null or not null");
        }

        profileCode = profile;
        workCode = workcode;
    }

    public EPW(String employerIrn) {

        this(InternalReferenceNumber.valueOf(employerIrn));
    }

    public EPW(String employerIrn, String profile, Integer workcode) {
        this(InternalReferenceNumber.valueOf(employerIrn), profile == null ? null : new ProfileCode(profile), workcode == null ? null : new WorkCode(workcode));
    }

    public int compareTo(EPW o) {

        if ((workCode == null) && (o.workCode != null)) {
            return -1;
        }
        else if ((workCode != null) && (o.workCode == null)) {
            return 1;
        }
        else if (workCode != null) {
            if (employerIrn.compareTo(o.employerIrn) == 0) {
                if (profileCode.compareTo(o.profileCode) == 0) {
                    return workCode.compareTo(o.workCode);
                }
                return profileCode.compareTo(o.profileCode);
            }

        }
        return employerIrn.compareTo(o.employerIrn);
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
        EPW other = (EPW) obj;
        if (employerIrn == null) {
            if (other.employerIrn != null) {
                return false;
            }
        }
        else if (!employerIrn.equals(other.employerIrn)) {
            return false;
        }
        if (profileCode == null) {
            if (other.profileCode != null) {
                return false;
            }
        }
        else if (!profileCode.equals(other.profileCode)) {
            return false;
        }
        if (workCode == null) {
            if (other.workCode != null) {
                return false;
            }
        }
        else if (!workCode.equals(other.workCode)) {
            return false;
        }
        return true;
    }

    public InternalReferenceNumber getEmployerIrn() {
        return employerIrn;
    }

    public ProfileCode getProfileCode() {
        return profileCode;
    }

    public WorkCode getWorkCode() {
        return workCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + (employerIrn == null ? 0 : employerIrn.hashCode());
        result = (prime * result) + (profileCode == null ? 0 : profileCode.hashCode());
        result = (prime * result) + (workCode == null ? 0 : workCode.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "(" + employerIrn.toString() + ", " + (profileCode == null ? "null" : profileCode.toString()) + ", " + (workCode == null ? "null" : workCode.toString()) + ")";
    }

}
