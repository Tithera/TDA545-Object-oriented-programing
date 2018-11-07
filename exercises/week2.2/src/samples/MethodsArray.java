package samples;

import java.util.Arrays;

import static java.lang.System.*;

/**
 * Method with an array parameter and possibly array return value
 */
public class MethodsArray {

    public static void main(String[] args) {
        new MethodsArray().program();
    }

    void program() {
        int[] arr1 = {7, 1, 0, 4, -2};   // Declare and initialize
        int[] arr2 = {5, 4, 3, 2, 1};

        out.println(Arrays.toString(arr1));
        zeroIt(arr1);
        out.println(Arrays.toString(arr1));

        addArrays(arr2, arr2);
        out.println(Arrays.toString(arr2));

        int[] r = addArrays2(arr2, arr2);
        out.println(Arrays.toString(r));

    }

    // Set all to 0. Array modified after method call
    void zeroIt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    // Add arrays assume same length, result in a1 (i.e. a1 changed)
    void addArrays(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            a1[i] = a1[i] + a2[i];
        }
    }

    // Add arrays but preserve parameters, return result array
    int[] addArrays2(int[] a1, int[] a2) {
        int[] result = {0, 0, 0, 0, 0};
        if (a1.length != a2.length || a1.length != result.length) {
            int[] empty = {};
            return empty;
        }
        for (int i = 0; i < a1.length; i++) {
            result[i] = a1[i] + a2[i];
        }
        return result;
    }


}


