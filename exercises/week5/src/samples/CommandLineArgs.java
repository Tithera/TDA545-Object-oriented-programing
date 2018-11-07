package samples;

import java.util.Arrays;

import static java.lang.System.out;

/*
 *  Command line arguments, this is not used it's only for the curious
 *
 *  It's possible to send arguments to the main method (often config data for program)
 *
 *  To see whats happening, run outside IntelliJ
 *
 *  1. Open a terminal
 *  2. Go to directory week6/out/production/week6
 *  3. Write: java samples/commandLineArgs hello world   (enter)
 */
public class CommandLineArgs {

    public static void main(String[] args) {
        out.print("Command line args are: ");
        out.println(Arrays.toString(args));
    }
}
