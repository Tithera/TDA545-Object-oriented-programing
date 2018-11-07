package assignments.basics;

import static java.lang.System.*;
import java.lang.Math;
import java.text.DecimalFormat;

/*
 *   Exercising while-loop
 */
public class WhileLoop {

    public static void main(String[] args) {
        new WhileLoop().program();
    }


    void program() {
        // Write your code here
        // Comment out when finished with one and continue with next

        /*
        //Loop 1 (-20, -19, ..., 3)

        int count = -20;
        while ( count <= 3) {
            out.print(count + ", " );
            count++;
        }
        */

        /*
        //Loop 2 (10, 9, ..., -10)

        int count = 10;
        while (count >= -10) {
            out.print(count + ", " );
            count--;
        }
        */

        /*
        //Loop 3 (5, 10, ..., 95, 100)

        int count = 5;
        while ( count <= 100 ) {
            out.print( count + ", " );
            count = count + 5;
        }
        */

        /*
        //Loop 4 (0.0, 0.3, ... 8.7, 9.0)

        double count = 0.0;
        double roundOff;

        while ( count <= 9.0) {
            roundOff = Math.round(count * 10.0) / 10.0;
            out.println( roundOff + ", ");
            count = count + 0.3;
        }
        */

        /*
        //Loop 5 (½, ¼, ...1/256 (inte 0.5, 0.25...))

        int numerator = 1;
        int denominator = 2;

        while ( denominator <= 256 ) {
            out.println(numerator + "/" + denominator);
            denominator = denominator * denominator;
        }
        */

    }
}
