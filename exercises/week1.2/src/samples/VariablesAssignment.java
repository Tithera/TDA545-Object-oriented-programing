package samples;


import static java.lang.System.*;

/**
 * Variables and Assignments
 */
public class VariablesAssignment {

    public static void main(String[] args) {
        new VariablesAssignment().program();
    }

    void program() {
        // int a;         // Bad! Must give initial value
        int a = 0;       // Declaration and initialization
        int b = 5;

        out.println(a);   // This will print a on screen, a 0 will show up, more to come ...
        out.println(b);   // 5

        a = 6;            // 0 gone now 6
        b = a;            // 5 gone, now 6
        out.println(b);   // 6

        b++;              // Increment
        out.println(b);   // 7
        b--;              // Decrement
        out.println(b);   // 6

        b++;
        a = b;
        out.println(a);   // 7


        a = a + 1;  // + is normal addition. Right side evaluated first, then copied to left
        out.println(a);   // 8

        b = b + 2;  // Again
        out.println(b);   // 9


        int c = a++ + a++;  // This is bad coding just to show a corner case! Don't use
        out.println(c);   // 17
        out.println(a);   // 10
    }
}
