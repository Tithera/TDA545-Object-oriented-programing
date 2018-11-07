package samples;

import static java.lang.Math.*;
import static java.lang.System.out;

/**
 * Built in Java math functions
 */
public class MathMethods {

    public static void main(String[] args) {
        new MathMethods().program();
    }

    void program() {
        double d = 2.1;

        // NOTE: import Math above
        out.println("Square root " + sqrt(d));  // All return a double value
        out.println("Square " + pow(d, 2));
        out.println("Floor " + floor(d));
        out.println("Ceil " + ceil(d));
        out.println(PI);  // Declared in Math library

        // As you know doubles are NOT exact
        double d1 = 1.0 - 0.7 - 0.3;
        double d2 = 1.0 - 0.6 - 0.4;
        out.println( d1 == d2);  // False
        // Better do like this
        out.println( abs(d1 - d2) < 0.000001); // True

        // Nested calls
        out.println(sqrt(pow(3, 2) + pow(4, 2)));

    }
}
