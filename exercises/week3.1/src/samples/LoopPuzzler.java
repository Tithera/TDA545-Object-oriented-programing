package samples;

import static java.lang.System.out;

/*
 *    A Puzzlers, plotting a pattern
 */
public class LoopPuzzler {

    public static void main(String[] args) {
        new LoopPuzzler().program();
    }

    void program() {

        // Plot a half square.
        for (int i = 10; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                out.print("X");
            }
            out.println();
        }
    }
}
