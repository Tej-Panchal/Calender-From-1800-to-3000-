import java.util.Scanner;

public class PrintCalenderMain {
	/**
	 * Use the getValidInt() method to get a valid year between 1800 and 3000.
	 * Within the do loop, enter a "y" or an "m" and if you answer "m" 
	 * it will also ask you for a number between 1 and 12 using the getValidInt() method. If
	 * you answered "y" then print out every month for that year. If you answered
	 * "m" then print out just the one month. If you answered anything else then
	 * output an error message.
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		// Prompt the user to enter the year

		boolean repeat;
		do {
			int year = PrintCalenderHelper.getValidInt(kb, "Enter a year between 1800 and 3000: ", 1800, 3000);
			kb.nextLine();
			// This will ask the user to enter the option
			System.out.println("Select one of the following options:");
			// The options are year or month of that year and it will print according to
			// their input
			System.out
			.println("To get the month calendar press m or M \nTo get the calendar for the year enter y or Y ");
			System.out.print("Enter your choice: ");
			String choice = kb.nextLine();
			// This is month option
			if (choice.equalsIgnoreCase("m")) {
				int month = PrintCalenderHelper.getValidInt(kb, "Enter the month of the year (1 through 12):", 1, 12);
				printMonth(year, month);
			}
			// this is year option
			else if (choice.equalsIgnoreCase("y")) {
				for (int i = 1; i <= 12; i++) {
					printMonth(year, i);
				}
			}
			String answer;

			do {
				System.out.println();
				// This will ask the user that the user want to run this agian
				System.out.print("Do you have another year to print the calender:yes/no--> ");
				answer = kb.next();
			}
			// If say no then the project will be end
			while (!answer.equalsIgnoreCase("no") && !
					// if say yes then it will do the same thing as it done before
					answer.equalsIgnoreCase("yes"));
			repeat = answer.equalsIgnoreCase("yes");
		}
		// repeat as long as the user wants to
		while (repeat);

	}

	/**
	 * Outputs a month on the calendar for a given year. Use the printTitle() and
	 * the printMonthBody() methods to do the actual printing month and year
	 */
	public static void printMonth(int year, int month) {
		// call the method printTitle with the values year and month
		printMonthTitle(year, month);

		// call the method printMonthBody with the values year and month
		printMonthBody(year, month);
	}

	/**
	 * Prints the month name, a separator line and then the days of the week (Sun,
	 * Mon, ..., Sat) year The year of the month title to print. month The month to
	 * print.
	 */
	public static void printMonthTitle(int year, int month) {

		// output the title for each month of the year
		String m = PrintCalenderHelper.getMonthName(month);

		// This will print the name of the month and year
		System.out.println("\n");
		System.out.println("        " + m + " " + year);

		System.out.println("-----------------------------");

		// This will print the headings of the whole week
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");
	}

	/**
	 * This method prints the body of the calendar for the given month by first
	 * determining the start day of the month (using the getStartDay() method) and
	 * then calling the print method to actually print the rest of the calendar.
	 */
	public static void printMonthBody(int year, int month) {
		// call the method getStartDay to get the start day for the given month of
		// the year
		int startDay = PrintCalenderHelper.getStartDay(year, month);

		// call number of days in the month method form the helper class

		// call the method print to print the calendar for the month and pass
		// the first day of the month as the parameter
		print(startDay, year, month);
	}

	/**
	 * Prints the calendar for the given month. startDay The day of the week that
	 * the month begins on. (0 = Sunday and 6 = Saturday) year The year of the month
	 * month The month to print. (1 = January and 12 = December)
	 */
	public static void print(int startDay, int year, int month) {
		// call the method getNumberOfdaysInMonth to find out the number of the
		// days in the month
		// NOD means number of days
		int NOD = PrintCalenderHelper.getNumberOfDaysInMonth(year, month);

		// use a for loop to print spaces up to the start day for each month
		for (int a = 1; a <= startDay; a++) {
			System.out.print("    ");
		}

		// use another for loop to print the rest of the days in the calendar
		for (int b = 1; b <= NOD; b++) {

			// If else statement to get days
			if ((startDay + b) % 7 != 0) {
				System.out.printf("%4d", b);
			}

			else if ((startDay + b) % 7 == 0) {
				System.out.printf("%4d\n", b);
			}

		}
		// if the month is November calculate the thanksgiving day and output
		if (month == 11) {
			int thanks = PrintCalenderHelper.thanks(startDay);
			System.out.println("\n**Thanks Giving Day is on the " + thanks + "th");
			System.out.println("\n Its your birthday on 23rd november");
		}
		System.out.println();
	}
}