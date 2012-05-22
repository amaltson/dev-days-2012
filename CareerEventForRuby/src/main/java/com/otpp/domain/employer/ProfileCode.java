package com.otpp.domain.employer;

import java.io.Serializable;

/**
 * A profile code describes a named profile type used to identify calendars, contracts, and teachers' roles
 */
public final class ProfileCode implements Comparable<ProfileCode>, Serializable {

    private static final long serialVersionUID = -5193765290736631L;

    /**
     * Profile code used to identify hybrid calendars which are calendars created by combining parts of multiple calendars.
     */
    public final static ProfileCode HYBRID = new ProfileCode("Hybrid");

    /**
     * Code used when what is posted is the "actual" compensation reported.
     */
    public final static ProfileCode ACTUAL = new ProfileCode("ACTUAL");

    private final String profileCode;

    public ProfileCode(String profileCode) {
        if (profileCode == null) {
            throw new NullPointerException("Attempting to create a Profile code for null. Set the value of the ProfileCode you are assigning to to null instead");
        }

        this.profileCode = profileCode;
    }

    public static ProfileCode valueOf(String profileCode) {
        return new ProfileCode(profileCode);
    }

    public String getProfileCode() {
        return profileCode;
    }

    @Override
    public String toString() {
        return profileCode;
    }

    public int compareTo(ProfileCode o) {
        return profileCode.compareTo(o.profileCode);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + (profileCode == null ? 0 : profileCode.hashCode());
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
        ProfileCode other = (ProfileCode) obj;
        if (profileCode == null) {
            if (other.profileCode != null) {
                return false;
            }
        }
        else if (!profileCode.equals(other.profileCode)) {
            return false;
        }
        return true;
    }

}
