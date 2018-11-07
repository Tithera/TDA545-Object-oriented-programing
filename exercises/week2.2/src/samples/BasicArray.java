package samples;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Basic use of Arrays.
 *
 * Traversing array, see for-loop
 */
public class BasicArray {

    public static void main(String[] args) {
        new BasicArray().program();
    }

    void program() {
        int i = 8;
        int[] arr = {7, 1, 0, 4, -2};   // Declare and initialize

        out.println(arr);                  // Bad output style
        out.println(Arrays.toString(arr));  // Much better (see import)

        out.println(arr[0]);       // Use index to access single variable

        arr[0] = 2;     // Assign
        arr[1] = i;
        i = arr[2];
        arr[4]++;       // Increment
        arr[2] = arr[3];   // More assignment


        //arr[5]++;      // Exception, index outside

        int j = 2;
        arr[j] = 2;
        arr[j + 1] = arr[j];
        arr[j] = arr[arr[j - 2]];    // Hard to understand avoid!


    }
}
