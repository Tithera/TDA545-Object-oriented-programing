package samples;

import static java.lang.System.*;

/**
 * The if statement (selection)
 */
public class IfStatement {

    public static void main(String[] args) {
        new IfStatement().program();
    }


    void program() {
        int i = 2;
        int j = 5;
        int k = 20;

        // If statement (NOTE: "{" on same line!)
        if (i == 2) {                       // if expression true ...
            out.println("i is 2");          // .. do this. Continue after }
        }

        // If-else statement
        if (j > 3) {                 // if expression true ...
            out.println("j > 3");    //... do this...
        } else {                     // ... else ...
            out.println("j <= 3");   // ... do this. Continue after }
        }

        // If-else if-statement (else if-ladder). (NOTE: Only one of is executed)
        if (j == 3) {                           // if expression true ...
            out.println("j is 3");              //... do this...
        } else if (k <= 20) {                   // ... else if this expression true ...
            out.println("k <= 20");             // ... do this ...
        } else {                                // ... else ...
            out.println("j != 3 and k > 20");   // ...do this
        }
    }
}
