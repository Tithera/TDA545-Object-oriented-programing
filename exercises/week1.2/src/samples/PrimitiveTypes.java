package samples;

import static java.lang.System.*;

/**
 * Primitive types
 */
public class PrimitiveTypes {

    public static void main(String[] args) {
        new PrimitiveTypes().program();
    }

    private void program() {
        int i = 1;
        double d = 2.5;
        char ch = 'a';

        d = i;                  // Ok int subset of double
        //i = d;                // No! will loose information
        out.println(d);

        d = ch;                 // Ok, char (small int) also subset
        //ch = d;               // No, will loose information
        out.println(d);

        i = ch;                 // Ok, Small int to bigger int
        //ch = i;               // No, will loose information
        out.println(i);


        // All char have a char code
        int ch3 = 'a';       // Compatible with int
        out.println(ch3);    // 97 the char code

        char ch4 = 'a' + 'b';
        out.println(ch4); // Not "ab"! Will add character codes (numeric values)

        // Unicode for uppercase Greek omega character
        char omega = '\u03A9';
        out.println(omega);

        // Escape chars used in string (\n = new line)
        out.print("Hej \npå \ndej\n");

    }

}
