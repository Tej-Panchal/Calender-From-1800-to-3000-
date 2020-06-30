import java.util.Scanner;

public class PrintCalenderHelper {
	/**
	 * Prompts the user and returns a number between min and max. Continually
	 * prompts until a valid number is entered. kb The Scanner object to read from
	 * System.in prompt The prompt for the user min The smallest value that the
	 * number can be. max The largest value that the number can be. return A number
	 * between min and max.
	 */
	public static int getValidInt(Scanner kb, String prompt, int min, int max) {

		int result;

		// Loop until valid input is read in
		do {

			// Prompt user and loop until they have entered a number
			System.out.print(prompt);
			while (!kb.hasNextInt()) {
				kb.nextLine();
				System.out.print(prompt);
			}

			// Read in the number
			result = kb.nextInt();
		} while (result < min || result > max);

		// Return the result
		return result;
	}

	/**
	 * This method calculates the day that Thanksgiving is on. Thanksgiving is
	 * always on the fourth Thursday of November. Depending on the first day of the
	 * month, a constant needs to be added to 3 * 7 since we have three full weeks.
	 * For example, if the first day of the month is on a Sunday then for that month
	 * Thanksgiving will be on 5 + 3 * 7 = 26th day of November. startDay The day of
	 * the week that November starts on (0 = Sunday) return The day in November that
	 * Thanksgiving is on that day.
	 */

	public static int thanks(int startDay) {

		// Decalre a variable method for Thanksgiving
		int Thanksgiving = (7 * 3) + 1 + ((11 - startDay) % 7);
		// This will return the Thanksgiving
		return Thanksgiving;
	}

	/**
	 * Given the Month number (1 through 12), returns the month name (January
	 * through December). This works well with a switch statement if you would like
	 * to use one. month The month number (1 through 12) return The month name
	 * (January through December)
	 */

	public static String getMonthName(int month) {

		if (month == 1) {
			return "January ";
		}

		else if (month == 2) {
			return "Febuary ";
		}

		else if (month == 3) {
			return "March ";
		}

		else if (month == 4) {
			return "April ";
		}

		else if (month == 5) {
			return "May ";
		}

		else if (month == 6) {
			return "June ";
		}

		else if (month == 7) {
			return "July ";
		}

		else if (month == 8) {
			return "August ";
		}

		else if (month == 9) {
			return "September ";
		}

		else if (month == 10) {
			return "October ";
		}

		else if (month == 11) {
			return "November ";
		}

		else if (month == 12) {
			return "December ";
		}
		return null;

	}

	/**
	 * This method returns the day of the week that the first day of a month occurs
	 * on. First it uses the getTotalNumberOfDays() method to get the number of days
	 * elapsed since January 1st, 1800 which was on a Wednesday (3). With total
	 * number of days since 1/1/1800 we can add 3and then mod by 7 to get the day of
	 * the week that a month starts on.
	 */

	public static int getStartDay(int year, int month) {
		// call the method getTotalNumberOfDays and store it in a variable
		int totalnumberofdays = getTotalNumberOfDays(year, month);

		// called start
		// add 3 to the variable start and % 7
		int Start = (totalnumberofdays + 3) % 7;

		// return start
		return Start;
	}

	/**
	 * Returns the total number of the days up to the given month in the given year
	 * since January 1st, 1800. For example, passing 2 for the month (February) and
	 * 1800 for the year should return 31 since 31 days would have had to pass to
	 * get to 2/1/1800. Similarly, passing 2 for the month and 1801 for the year
	 * should return 396 (365 + 31) since 1800 was not a leap year. This method
	 * should use getNumberOfDaysInMonth() and isLeapYear() to calculate the result.
	 * return The total number of days up to the given month for a given year. For
	 * example, passing 2 for the month (February) should return 31 because there
	 * are always 31 days before February.
	 */

	public static int getTotalNumberOfDays(int year, int month) {
		int total = 0;
		int totalmonth = 0;
		// use for loop to get the total number of days between the 1800 to year - 1
		for (int j = 1800; j < year; j++) {

			// put the condition that if the year is Leap year
			// then return this else the other option
			if (isLeapYear(j)) {
				total += 366;
			} else {
				total += 365;
			}
		}

		// to add the days from jan month to the month prior
		for (int i = 1; i < month; i++) {

			// call get Number Of Days In Month method
			totalmonth += getNumberOfDaysInMonth(year, i);
		}
		int totalnumdays = totalmonth + total;
		return totalnumdays;
	}

	/**
	 * Returns the number of the days in the given month of the given year. Take
	 * leap year into consideration. year The year for the month to determine month
	 * The month to determine return The total number of days in the given month.
	 */

	public static int getNumberOfDaysInMonth(int year, int month) {

		// For January
		if (month == 1) {
			return (31);
		}

		// For February
		else if (month == 2) {

			// for leap year only
			if (isLeapYear(year) == true) {
				return (29);
			} else {
				return (28);
			}
		}

		// For March
		else if (month == 3) {
			return (31);
		}

		// For April
		else if (month == 4) {
			return (30);
		}

		// For May
		else if (month == 5) {
			return (31);
		}

		// For June
		else if (month == 6) {
			return (30);
		}

		// For July
		else if (month == 7) {
			return (31);
		}

		// For August
		else if (month == 8) {
			return (31);
		}

		// For September
		else if (month == 9) {
			return (30);
		}

		// For October
		else if (month == 10) {
			return (31);
		}

		// For November
		else if (month == 11) {
			return (30);
		}

		// For December
		else if (month == 12) {
			return (31);
		}

		return month;
	}

	//Returns true if the given year is leap, false otherwise.

	public static boolean isLeapYear(int year) {

		// A year is a leap year if it is divisible by 400 or
		// if the year is divisible by 4 but not divisible by 100
		if (year % 400 == 0 || ((year % 4 == 0) && (year % 100 != 0))) {

			return true;
		}

		else {

			return false;
		}
	}
}