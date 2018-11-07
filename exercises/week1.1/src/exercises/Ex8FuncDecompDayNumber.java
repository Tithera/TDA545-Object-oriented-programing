package exercises;

import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;
import static java.lang.System.out;

/*
 * Program to calculate the day number for same day in a given year.
 * - You should use methods and functional decomposition.
 * - To check solution, see http://mistupid.com/calendar/dayofyear.htm
 *
 * See:
 * - FuncDecompLCR
 */

public class Ex8FuncDecompDayNumber {

    public static void main(String[] args) {
        new Ex8FuncDecompDayNumber().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        int year;
        int month;
        int day;
        int numberOfDays = 0;
        int loopMonth;
        boolean leapYear;
        boolean month31;
        boolean month30;


        // -- In ----------------
        out.print("Input a year > ");
        year = sc.nextInt();
        out.print("Input a month number > ");
        month = sc.nextInt();
        out.print("Input a day number > ");
        day = sc.nextInt();


        // --- Process ---------
        loopMonth = month - 1;

        while ( loopMonth > 0 ) {

            month31 = loopMonth == 1 || loopMonth == 3 || loopMonth == 5 || loopMonth == 7 || loopMonth == 8 || loopMonth == 10 || loopMonth == 12;

            month30 = loopMonth == 4 || loopMonth == 6 || loopMonth == 9 || loopMonth == 11;

            if ( month31 ) {

                numberOfDays = numberOfDays + 31;

            } else if ( month30 ) {

                numberOfDays = numberOfDays + 30;

            } else if ( loopMonth == 2 ) {

                numberOfDays = numberOfDays + 28;

            }

            loopMonth = loopMonth - 1;

        }

        //Calculate leap year
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ) {

            leapYear = true;
            numberOfDays = numberOfDays + 1;

        } else {

            leapYear = false;

        }

        numberOfDays = numberOfDays + day;


        // ---- Out ----
        printResult(year, month, day, numberOfDays, leapYear);

    }


    private void printResult(int year, int month, int day, int numberOfDay, boolean leapYear) {

        out.println("Day number for " + day + "/" + month + " in " + year + " is: " + numberOfDay);

        if (leapYear) {
            out.println(year + " is a leap year");
        } else {
            out.println(year + " is not a leap year");
        }

    }

}
