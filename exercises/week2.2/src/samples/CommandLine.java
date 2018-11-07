package samples;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Basic command line menu
 */
public class CommandLine {

    public static void main(String[] args) {
        new CommandLine().program();
    }

    void program() {

        final int roll = 0;
        final int move = 1;
        final int exit = 2;
        boolean done = false;

        Scanner scan = new Scanner(in);

        while (!done) {     // Command loop
            out.print("Enter command > ");  // Prompt user
            int cmd = scan.nextInt();      // Loop and a half
            switch (cmd) {
                case roll:
                    out.println("roll selected");  // Act on command
                    break;
                case move:
                    out.println("move selected");
                    break;
                case exit:
                    done = true;   // Leave loop
                    break;
                default:
                    out.println("?");     // Bad command
            }
        }  // <--------------------- end command line

        out.println("program finished");
    }
}
