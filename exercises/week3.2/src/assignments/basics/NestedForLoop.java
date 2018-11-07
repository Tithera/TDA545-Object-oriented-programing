package assignments.basics;

import static java.lang.System.out;

/*
 * Exercising nested for loops
 */
public class NestedForLoop {

    public static void main(String[] args) {
        new NestedForLoop().program();
    }


    void program() {
        // Write solution (for loops) directly here

        // a) Plot a half square. May only use for-loops, out.print("X") and out.println()

        for ( int i = 0; i <= 7; i++ ) {

            for ( int j = 0; j < i; j++ ) {

                out.print("X");

            }
            out.println();
        }

        out.println();

        // b) Plot a rhombus

        for ( int i = 0; i < 4; i++ ) {

            for ( int j = 0; j < i; j++) {
                out.print(" ");
            }

            out.println("XXXXXXXXXX");

        }

    }
}
