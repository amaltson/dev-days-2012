package com.otpp.careerevent.events;

import java.math.BigDecimal;

import com.otpp.domain.date.Date;

public class AbsenceEvent extends AbstractEvent implements Comparable<AbsenceEvent> {

    protected static final String ATTRIBUTE_NUMBER_BIRTHS = "#PREGNANCIES";
    protected static final String ATTRIBUTE_EXPIRY_OVERRIDE_DATE = "PAY EXPIRY OVERRIDE";
    protected static final String ATTRIBUTE_END_DATE_OVERRIDE = "EXP DATE OVERRIDE";
    protected static final String ATTRIBUTE_MANUAL_TAX_COMMENT = "MANUAL TAX COMMENT";
    protected static final String ATTRIBUTE_OVERRIDE_COMMENT = "OVERRIDE COMMENT";
    private static final String ATTRIBUTE_RPP_END_DATE = "RPP END";
    private static final String ATTRIBUTE_RPP_START_DATE = "RPP START";
    private static final String ATTRIBUTE_MANUAL_TAX = "MANUAL TAX";
    protected static final String ATTRIBUTE_INELIGIBLE_PURCHASE_PERIOD_START = "INELIGIBLE START";
    protected static final String ATTRIBUTE_INELIGIBLE_PURCHASE_PERIOD_END = "INELIGIBLE END";

    private static final int MAXIMUM_LENGTH_FOR_COMMENT_STRINGS = 100;
    protected final static int ABSENCE_EVENT_EXPIRY_WINDOW_YEARS = 5;
    private final static int ABSENCE_EVENT_EXPIRY_GRACEPERIOD_MONTHS = 0;
    private final static int ABSENCE_EVENT_EXPIRY_NOTIFICATION_WINDOW_MONTHS = -6;

    private Integer linkedPurchaseId = null;
    private final static int NUMBER_OF_PREGNANCIES_ROUNDING_SCALE = 2;

    private static final long serialVersionUID = 4102814184232470681L;

    /**
     * This will return the date WE TELL THE MEMBER THAT can no longer 
     * pay for a buyback product associated with this event
     */
    public Date getPaymentExpiryDateForDisplayToMember() {
        return getEndDate();
    }

    /**
     * This will return the date on which a member can ACTUALLY no longer 
     * pay for a buyback product associated with this event
     */
    public Date getPaymentExpiryDate() {
        return getEndDate();
    }

    /**
     * This will return the date on which we notify the member about
     * the buyback opportunity expiring
     */
    public Date getPaymentExpiryNotificationDate() {
        return getEndDate();
    }

    /**
     * This will return "true" if the event is no longer able to
     * be bought back due to the {@link #getPaymentExpiryDate()} having passed
     * 
     * @return
     */
    public boolean isExpiredForBuyback() {
        return Date.today().isAfter(getPaymentExpiryDate());
    }

    /**
     * @return true if member was contributing to an RPP during this absence period
     */
    public boolean hasOverlappingRppContribution() {
        return false;
    }

    public String getManualTaxComment() {
        return getStringEventAttribute(AbsenceEvent.ATTRIBUTE_MANUAL_TAX_COMMENT);
    }

    public String getOverrideComment() {
        return getStringEventAttribute(AbsenceEvent.ATTRIBUTE_OVERRIDE_COMMENT);
    }

    /**
     * This will return the product ID of the buyback product that is
     * linked to this event 
     * 
     * @return
     */
    public Integer getLinkedBuybackId() {
        return linkedPurchaseId;
    }

    public void setLinkedBuybackId(Integer linkedBuybackId) {
        linkedPurchaseId = linkedBuybackId;
    }

    /**
     * This method will answer "true" if the {@link AbsenceEvent} is linked to an existing purchase.
     * 
     * @return
     */
    public boolean isLinkedToBuyback() {
        return getLinkedBuybackId() != null;
    }

    /**
     * This method will answer "true" if the {@link AbsenceEvent} is a candidate
     * for the basis for a Buyback Product
     * 
     * @return
     */
    public boolean isBuybackOpportunity() {
        return true;
    }

    @Override
    public boolean isApproved() {
        // for absence events, they are considered approved if the source is EMPLOYER, otherwise they aren't approved. The
        // thinking is that if the employer doesn't like an event that is TPP or CLIENT sourced they will be able to just delete
        // the event
        return true;
    }

    public BigDecimal getNumberOfPregnancies() {
        return BigDecimal.ZERO;
    }

    public Date getExpiryOverrideDate() {
        return getDateEventAttribute(AbsenceEvent.ATTRIBUTE_EXPIRY_OVERRIDE_DATE);
    }

    @Override
    public int compareTo(AbsenceEvent o) {
        return getEventId().compareTo(o.getEventId());
    }

    public Date getFinancialEndDate() {
        return getEndDate();
    }

    public Date getEndDateOverride() {
        return getDateEventAttribute(AbsenceEvent.ATTRIBUTE_END_DATE_OVERRIDE);
    }

    public boolean isTaxCalculatedManually() {
        return getBooleanEventAttribute(AbsenceEvent.ATTRIBUTE_MANUAL_TAX);
    }

    public boolean isIneligibleForPurchase() {
        return false;
    }

    public boolean isPartiallyIneligibleForPurchase() {
        return false;
    }

    private void throwExceptionOnInvalidCommentLength(String comment) {
        if ((comment != null) && !comment.isEmpty() && (comment.length() > AbsenceEvent.MAXIMUM_LENGTH_FOR_COMMENT_STRINGS)) {
            throw new IllegalArgumentException("Comment length cannot be greater than " + AbsenceEvent.MAXIMUM_LENGTH_FOR_COMMENT_STRINGS + " characters");
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + ((linkedPurchaseId == null) ? 0 : linkedPurchaseId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (!super.equals(obj)) {
            return false;
        }

        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AbsenceEvent other = (AbsenceEvent) obj;
        if (linkedPurchaseId == null) {
            if (other.linkedPurchaseId != null) {
                return false;
            }
        }
        else if (!linkedPurchaseId.equals(other.linkedPurchaseId)) {
            return false;
        }
        return true;
    }

}
