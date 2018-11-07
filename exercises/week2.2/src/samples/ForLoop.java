package samples;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * travers an array (access all variables, left to right or right to left)
 */
public class ForLoop {

    public static void main(String[] args) {
        new ForLoop().program();
    }

    void program() {

        for (int i = 0; i < 10; i++) {  // Basic for loop, going uo
            out.print(i);
        }

        out.println();

        for (int i = 9; i >= 0; i--) {  // Basic for loop, going down
            out.print(i);
        }

        out.println();

        for (int i = 0; i < 10; i = i + 2) {  // Basic for loop, step
            out.print(i);
        }

        out.println();

        // Traverse array
        int[] arr = {7, 1, 0, 4, -2};   // Declare and initialize
        for (int i = 0; i < arr.length; i++) {   // Use for-loop
            out.print(arr[i]);
        }

        out.println();

        for (int i = 0; i < arr.length - 1; i++) {   // Move values one left
            arr[i] = arr[i + 1];
        }
        out.println(Arrays.toString(arr));
    }
}
