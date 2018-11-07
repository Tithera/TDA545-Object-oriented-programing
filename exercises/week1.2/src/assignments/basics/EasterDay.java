package assignments.basics;

import static java.lang.System.*;

import java.util.Scanner;

/*
 *  Program to calculate easter day for some year (1900-2099)
 */
public class EasterDay {

    public static void main(String[] args) {
        new EasterDay().program();
    }

    void program() {
        // Write your code here
        // Structure program as: Input -> Process -> Output

        int a, b, c, d, e, s, t;   // Avoid on same line (acceptable here)
        int date;
        int year;
        int month;


        //Input
        out.print("Input a year (1900-2099) > ");
        Scanner sc = new Scanner(in);

        year = sc.nextInt();

        //Process
        a = year % 19;
        b = year % 4;
        c = year % 7;

        s = ( 19 * a ) + 24;
        d = s % 30;
        t = ( 2 * b ) + ( 4 * c ) + ( 6 * d ) + 5;
        e = t % 7;

        date = 22 + d + e;

        if ( date < 32) {

            month = 3;

        } else {

            if ( date == 26 ) {

                date = 19;
                month = 4;

            } else if ( date == 25 && a == 16 && d == 28 ) {

                date = 18;
                month = 4;

            } else {

                date = d + e - 9;
                month = 4;

            }
        }

        //Output
        out.println("Easter day for " + year + " is : " + date + "/" + month );

    }
}
