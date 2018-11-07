package samples;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.*;
import static java.lang.Math.*;

/**
 * Using wrapper types for primitives types
 */
public class WrapperTypes {

    public static void main(String[] args) {
        new WrapperTypes().program();
    }

    final Random rand = new Random();

    void program() {
        Integer i = 4;   // Conversion from int to Integer ...
        int j = i;        // ... and back


        int[] k = {1, 2, 3};
        //shuffle(k);               // No! Not primitive type

        // Will convert int elements to Integer objects
        Integer[] is = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffle(is);   // Yes
        out.println(Arrays.toString(is));
    }

    // Only works for reference types
    <T> void shuffle(T[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i);
            T k = arr[i];
            arr[i] = arr[j];
            arr[j] = k;
        }
    }

}
