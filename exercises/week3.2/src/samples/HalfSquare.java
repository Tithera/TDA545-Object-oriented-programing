package samples;

import static java.lang.System.out;

/*
 * Exercising nested for loops
 */
public class HalfSquare {

    public static void main(String[] args) {
        new HalfSquare().program();
    }

    void program() {

        // Plot a half square. May only use for-loops, out.print("X") and out.println()
        for (int i = 10; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                out.print("X");
            }
            out.println();
        }

    }

}
