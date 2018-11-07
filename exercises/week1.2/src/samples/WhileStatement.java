package samples;

import static java.lang.System.*;

/**
 * The while statement (iteration)
 */
public class WhileStatement {

    public static void main(String[] args) {
        new WhileStatement().program();
    }

    void program() {

        // Going up
        int i = 0;    // Set start value for counter
        while (i < 10) {
            out.println("i is : " + i);
            i++;     // Increment counter (last)
        }
        out.println("i after loop is : " + i);   // NOTE!

        // Going down
        i = 10;
        while (i > 0) {
            out.println("i is : " + i);
            i--;
        }
        out.println("i after loop is : " + i);   // NOTE!


        // Step
        i = 0;
        while (i < 20) {
            out.println("i is : " + i);
            i += 2;  // Step by 2
        }
        out.println("i after loop is : " + i);   // NOTE!
    }
}
