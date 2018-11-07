package assignments.basics;

import java.util.Arrays;

import static java.lang.System.*;

/**
 * Exercising methods with array parameters (using only integer arrays)
 */
public class MethodsWithArrays {

    public static void main(String[] args) {
        new MethodsWithArrays().program();
    }


    void program() {
        int[] arr = {1, 4, 3, 8, 4, 9, 2, -1};
        out.println(Arrays.toString(arr));  // Use Arrays.toString() to get a nice print out
        // Testing the methods.
        // All output should print "true" (uncomment as needed)
        out.println(sumArr(arr) == 30);
        //out.println(maxIndex(arr) == 5);
        //out.println(countN(arr, 4) == 2);
    }

    // ------------- Write methods below this line --------------------


    //Method sumArr, en metod som givet en array av heltal beräknar summan av dessa.
    int sumArr ( int[] array ) {
        int sum = 0;

        for ( int i = 0; i < array.length; i ++ ) {
            sum = sum + array[i];
        }
        return sum;
    }


    /*
    //Method maxIndex, en metod som returnerar index till största värdet i en heltals-array.
    int maxIndex ( int[] array ) {
        int maxIndex = 0;

        for ( int i = 0; i < array.length; i++ ) {

            if ( array[i] >= maxIndex ) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    */

    /*
    //Method countN, en metod som räknar antal förekomster av ett visst tal i en heltals-array.
    int countN ( int[] array, int n ) {
        int sum = 0;

        for ( int i = 0; i < array.length; i++ ) {

            if ( array[i] == n ) {
                sum = sum + 1;
            }
        }
        return sum;
    }
    */
}
