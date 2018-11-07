package exercises;

import static java.lang.System.out;

/*  Some puzzlers
 *
 *  See:
 *  - LoopPuzzler
 */

public class Ex1LoopPuzzlers {

    public static void main(String[] args) {
        new Ex1LoopPuzzlers().program();
    }

    void program() {

        // Multiplication table
        out.println("Plot a multiplication table:");
        for ( int i = 1; i < 11; i++ ) {

            for ( int j = 1; j < 11; j++ ) {
                out.print(i*j + " ");
            }
            out.println();
        }

        // Plot a half square
        out.println();
        out.print("Plot a half square:");
        for ( int i = 0; i < 8; i++ ) {
            for ( int j = 0; j < i; j++ ) {
             out.print("X");
            }
            out.println();
        }

        // Plot a rhombus
        out.println();
        out.println("Plot a rhombus:");
        for ( int i = 0; i < 6; i++ ) {
            for ( int j = 0; j < i; j++ ) {
                out.print(" ");
            }
            out.println("XXXXXXXX");
        }

    }
}
