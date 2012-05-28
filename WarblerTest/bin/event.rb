class Event < ActiveRecord::Base
  # by default ActiveRecord looks for an "events" table in DB
  # but our table is called SEP790
  self.table_name = "SEP790"
  
  alias_attribute :legalEntityType, :LEGAL_ENTITY_TYPE
  alias_attribute :legalEntityIrn, :LEGAL_ENTITY_IRN
  alias_attribute :employerIrn, :EMPLOYER_IRN
  alias_attribute :employerProfileId, :EMPLOYER_PROFILE_ID
  alias_attribute :workCode, :WORK_CODE
  alias_attribute :issue, :ISSUE
  alias_attribute :source, :SOURCE
  alias_attribute :owner, :OWNER
  alias_attribute :channel, :CHANNEL
  alias_attribute :schoolYear, :SCHOOL_YEAR
  alias_attribute :calendarYear, :CALENDAR_YEAR
  alias_attribute :eventCode, :EVENT_CODE
  alias_attribute :eventClass, :EVENT_CLASS
  alias_attribute :reasonCode, :REASON_CODE
  alias_attribute :schoolYear, :SCHOOL_YEAR
  alias_attribute :formula, :FORMULA
  alias_attribute :effectiveDate, :EFFECTIVE_DATE
  alias_attribute :expiryDate, :EXPIRY_DATE
  alias_attribute :status, :STATUS
  
  java_signature 'java.lang.String toString()'
  def toString
    "IRN:" + self.legalEntityIrn + ", EPW:" + self.employerIrn + "," + self.employerProfileId + "," + self.workCode.to_s + ", ISSUE:" + self.issue
  end
  
end
