package com.otpp.domain.date;

public enum MonthOfYear {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;

    /**
     * Returns the month of year object corresponding to the index passed in this date.
     * Null is returned 
     * Months are 1 indexed where 1 = January, 2 = February ... 12 = December
     * 
     * @return a {@link MonthOfYear} representing the month if it is a specific date. Undefined if it is a past date or future
     *         date.
     */
    public static MonthOfYear getMonthOfYear(int monthIndex) {
        switch (monthIndex) {
            case 1:
                return MonthOfYear.JANUARY;
            case 2:
                return MonthOfYear.FEBRUARY;
            case 3:
                return MonthOfYear.MARCH;
            case 4:
                return MonthOfYear.APRIL;
            case 5:
                return MonthOfYear.MAY;
            case 6:
                return MonthOfYear.JUNE;
            case 7:
                return MonthOfYear.JULY;
            case 8:
                return MonthOfYear.AUGUST;
            case 9:
                return MonthOfYear.SEPTEMBER;
            case 10:
                return MonthOfYear.OCTOBER;
            case 11:
                return MonthOfYear.NOVEMBER;
            case 12:
                return MonthOfYear.DECEMBER;
            default:
                throw new IllegalArgumentException("Invalid month index " + monthIndex + " entered.  Must be between 1 and 12.");
        }
    }
}
