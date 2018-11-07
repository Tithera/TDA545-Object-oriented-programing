package assignments.basics;

import static java.lang.System.*;

/*
 * Exercising methods with primitive types
 */
public class Methods {

    public static void main(String[] args) {
        new Methods().program();
    }

    void program() {
        // Testing the methods.
        // All output should print "true" (comment/uncomment as needed)
        /*
        out.println(sign(-100) == -1);
        out.println(sign(0) == 0);
        out.println(sign(14) == 1);
        */

        /*
        out.println(factorial(0)== 1);
        out.println(factorial(1)== 1);
        out.println(factorial(2)== 2);
        out.println(factorial(3)== 6);
        */

        /*
        out.println(gcd(24, 8) == 8);
        out.println(gcd(7, 2) == 1);
        */

    }

    // ------------- Write your methods below this line --------------------

    /*
    //Sign method, en metod sign(int n) som returnerar -1, 0 elle 1 om n är negativt, noll respektive positivt heltal.
    int sign (int n) {

        if ( n > 1 ) {
            return 1;
        } else if ( n == 0 ) {
            return 0;
        } else if ( n < 1) {
            return -1;
        }

        return n;
    }
    */

    /*
    //Factorial method, skriv en metod som beräknar n! (fakultet) givet n.
    int factorial ( int n ) {

        int temp = 1;
        for (int i = 1; i <= n; i++) {
            temp = temp * i;
        }
        return temp;
    }
    */

    /*
    //Gcd method, skriv en metod som beräknar största gemensamma nämnare för två heltal.
    int gcd (int n, int m) {

        if ( n == 0 ) {

            return m;

        }

        while (m != 0) {

            if ( n > m ) {
                n = n - m;
            } else {
                m = m - n;
            }

        }
        return n;
    }
    */
}
