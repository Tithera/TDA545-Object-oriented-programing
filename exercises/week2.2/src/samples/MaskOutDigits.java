package samples;

import static java.lang.System.out;

/**
 * Accessing parts of an integer
 */
public class MaskOutDigits {

    public static void main(String[] args) {
        new MaskOutDigits().program();
    }

    void program() {
        int i = 53;

        int r = i % 10;    // Mask out 3
        int t = i / 10;    // Mask out 5

        out.println(r);
        out.println(t);

    }
}
