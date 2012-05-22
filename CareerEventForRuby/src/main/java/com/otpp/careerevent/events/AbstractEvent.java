package com.otpp.careerevent.events;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import com.otpp.core.InternalReferenceNumber;
import com.otpp.domain.date.Date;
import com.otpp.domain.employer.EPW;
import com.otpp.domain.employer.ProfileCode;
import com.otpp.domain.employer.WorkCode;

public abstract class AbstractEvent implements Serializable {

    private static final long serialVersionUID = 4102814184232470681L;

    private static final String DELETED_STATUS = "DEL";
    //even attribute
    private static final String SICK_DAYS = "SICK DAYS";

    private Integer eventId;
    private InternalReferenceNumber entityIrn;
    private Date startDate;
    private Date endDate;
    private EPW epw;
    private CareerEventType eventType;
    private String channel;
    private String eventCode;
    private String reasonCode;
    private String owner;
    private String status;
    private String issue;
    private String source;
    private static final Date DATE_MINIMUM = new Date(1900, 1, 1);

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer anEventId) {
        eventId = anEventId;
    }

    public InternalReferenceNumber getMemberIrn() {
        return entityIrn;
    }

    public void setMemberIrn(InternalReferenceNumber anIrn) {
        entityIrn = anIrn;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date aDate) {
        if (aDate == null) {
            throw new IllegalArgumentException("Cannot set the start date of " + this.getClass().getName() + " to null");
        }
        startDate = aDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date aDate) {
        if (aDate == null) {
            throw new IllegalArgumentException("Cannot set the end date of " + this.getClass().getName() + " to null");
        }
        endDate = aDate;
    }

    public CareerEventType getEventType() {
        return eventType;
    }

    public void setEventType(CareerEventType eventType) {
        this.eventType = eventType;
    }

    public EPW getEpw() {
        return epw;
    }

    public void setEpw(EPW epw) {
        this.epw = epw;
    }

    public InternalReferenceNumber getEmployerIrn() {
        return getEpw().getEmployerIrn();
    }

    public ProfileCode getEmployerProfile() {
        return getEpw().getProfileCode();
    }

    public WorkCode getWorkCode() {
        return getEpw().getWorkCode();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public InternalReferenceNumber getEntityIrn() {
        return entityIrn;
    }

    public void setEntityIrn(InternalReferenceNumber entityIrn) {
        this.entityIrn = entityIrn;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String anEventCode) {
        eventCode = anEventCode;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public BigDecimal getSickDays() {
        return BigDecimal.ZERO;
    }

    public boolean isApproved() {
        return true;
    }

    public boolean isDeletedLogically() {
        return (getStatus() != null) && getStatus().equalsIgnoreCase(AbstractEvent.DELETED_STATUS);
    }

    public Map<String, EventAttribute> getEventAttributes() {
        return null;
    }

    @Override
    public String toString() {
        String eventIdString = getEventId() == null ? "" : getEventId().toString();
        return getClass().getSimpleName() + ": [id=" + eventIdString + "] [type=" + getEventType() + "] [member=" + getMemberIrn() + "]";
    }

    protected Date getDateEventAttribute(String eventAttributeKey) {
        Date date = null;
        EventAttribute eventAttributeValue = getEventAttributes().get(eventAttributeKey);
        date = new Date(eventAttributeValue.getNumericValue().intValue());
        return date;
    }

    protected Integer getIntegerEventAttribute(String eventAttributeKey) {
        Integer value = null;
        EventAttribute eventAttributeValue = getEventAttributes().get(eventAttributeKey);
        if (eventAttributeValue != null) {
            value = eventAttributeValue.getNumericValue().intValue();
        }
        return value;
    }

    protected BigDecimal getBigDecimalEventAttribute(String eventAttributeKey) {
        BigDecimal value = null;
        EventAttribute eventAttributeValue = getEventAttributes().get(eventAttributeKey);
        if (eventAttributeValue != null) {
            value = eventAttributeValue.getNumericValue();
        }
        return value;
    }

    protected boolean getBooleanEventAttribute(String eventAttributeKey) {
        boolean value = false;
        EventAttribute eventAttributeValue = getEventAttributes().get(eventAttributeKey);
        if (eventAttributeValue != null) {
            value = "Y".equalsIgnoreCase(eventAttributeValue.getTextValue());
        }
        return value;
    }

    protected String getStringEventAttribute(String eventAttributeKey) {
        String value = null;
        EventAttribute eventAttributeValue = getEventAttributes().get(eventAttributeKey);
        if (eventAttributeValue != null) {
            value = eventAttributeValue.getTextValue();
        }
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((channel == null) ? 0 : channel.hashCode());
        result = (prime * result) + ((endDate == null) ? 0 : endDate.hashCode());
        result = (prime * result) + ((entityIrn == null) ? 0 : entityIrn.hashCode());
        result = (prime * result) + ((epw == null) ? 0 : epw.hashCode());
        result = (prime * result) + ((eventCode == null) ? 0 : eventCode.hashCode());
        result = (prime * result) + ((eventId == null) ? 0 : eventId.hashCode());
        result = (prime * result) + ((eventType == null) ? 0 : eventType.hashCode());
        result = (prime * result) + ((issue == null) ? 0 : issue.hashCode());
        result = (prime * result) + ((owner == null) ? 0 : owner.hashCode());
        result = (prime * result) + ((reasonCode == null) ? 0 : reasonCode.hashCode());
        result = (prime * result) + ((source == null) ? 0 : source.hashCode());
        result = (prime * result) + ((startDate == null) ? 0 : startDate.hashCode());
        result = (prime * result) + ((status == null) ? 0 : status.hashCode());
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
        AbstractEvent other = (AbstractEvent) obj;
        if (channel == null) {
            if (other.channel != null) {
                return false;
            }
        }
        else if (!channel.equals(other.channel)) {
            return false;
        }
        if (endDate == null) {
            if (other.endDate != null) {
                return false;
            }
        }
        else if (!endDate.equals(other.endDate)) {
            return false;
        }
        if (entityIrn == null) {
            if (other.entityIrn != null) {
                return false;
            }
        }
        else if (!entityIrn.equals(other.entityIrn)) {
            return false;
        }
        if (epw == null) {
            if (other.epw != null) {
                return false;
            }
        }
        else if (!epw.equals(other.epw)) {
            return false;
        }
        if (eventCode == null) {
            if (other.eventCode != null) {
                return false;
            }
        }
        else if (!eventCode.equals(other.eventCode)) {
            return false;
        }
        if (eventId == null) {
            if (other.eventId != null) {
                return false;
            }
        }
        else if (!eventId.equals(other.eventId)) {
            return false;
        }
        if (eventType == null) {
            if (other.eventType != null) {
                return false;
            }
        }
        else if (!eventType.equals(other.eventType)) {
            return false;
        }
        if (issue == null) {
            if (other.issue != null) {
                return false;
            }
        }
        else if (!issue.equals(other.issue)) {
            return false;
        }
        if (owner == null) {
            if (other.owner != null) {
                return false;
            }
        }
        else if (!owner.equals(other.owner)) {
            return false;
        }
        if (reasonCode == null) {
            if (other.reasonCode != null) {
                return false;
            }
        }
        else if (!reasonCode.equals(other.reasonCode)) {
            return false;
        }
        if (source == null) {
            if (other.source != null) {
                return false;
            }
        }
        else if (!source.equals(other.source)) {
            return false;
        }
        if (startDate == null) {
            if (other.startDate != null) {
                return false;
            }
        }
        else if (!startDate.equals(other.startDate)) {
            return false;
        }
        if (status == null) {
            if (other.status != null) {
                return false;
            }
        }
        else if (!status.equals(other.status)) {
            return false;
        }
        return true;
    }

}
