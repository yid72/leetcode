package dyd.leetcode;

/**
 * Given a date, return the corresponding day of the week for that date.
 *
 * The input is given as three integers representing the day, month and year respectively.
 *
 * Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
 * "Saturday"}.
 *
 *
 *
 * Example 1:
 *
 * Input: day = 31, month = 8, year = 2019
 * Output: "Saturday"
 * Example 2:
 *
 * Input: day = 18, month = 7, year = 1999
 * Output: "Sunday"
 * Example 3:
 *
 * Input: day = 15, month = 8, year = 1993
 * Output: "Sunday"
 */
public class Q01185_DayOfTheWeek {
    private static final int[] DAYS_IN_MONTH = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] WEEK_DAYS = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public String dayOfTheWeek(int day, int month, int year) {
        int daysToYear = 0;
        for (int i = 1900; i < year; i++) {
            daysToYear += isLeapYear(i) ? 366 : 365;
        }

        int dayOfYear = day;
        for (int i = 1; i < month; i++) {
            if (i == 2) {
                if (isLeapYear(year)) {
                    dayOfYear += 29;
                } else {
                    dayOfYear += 28;
                }
            } else {
                dayOfYear += DAYS_IN_MONTH[i - 1];
            }
        }

        int days = (daysToYear + dayOfYear - 1) % 7;
        return WEEK_DAYS[days];
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        test(1, 1, 1900);
        test(31, 8, 2019);
        test(18, 7, 1999);
        test(15, 8, 1993);
        test(11, 11, 2019);
        test(29, 2, 2008);
    }

    private static void test(int day, int month, int year) {
        Q01185_DayOfTheWeek q = new Q01185_DayOfTheWeek();
        System.out.printf("year=%d, month=%d, day=%d: %s\n", year, month, day, q.dayOfTheWeek(day, month, year));
    }
}
