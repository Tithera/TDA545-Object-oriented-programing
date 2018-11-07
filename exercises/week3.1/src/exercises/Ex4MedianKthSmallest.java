package exercises;

import java.util.Arrays;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.System.*;

/**
 *  Even more array methods, possibly harder ...
 */

public class Ex4MedianKthSmallest {

    public static void main(String[] args) {
        new Ex4MedianKthSmallest().program();
    }

    void program() {
        int[] arr1 = {9, 3, 0, 1, 3, -2};

        out.println(!isSorted(arr1));  // Is sorted increasing? No not yet!

        sort(arr1);     // Sort in increasing order original order lost!

        out.println(Arrays.toString(arr1).equals("[-2, 0, 1, 3, 3, 9]"));

        out.println(isSorted(arr1));  // Is sorted increasing? Yes!
        out.println(Arrays.toString(arr1));

        int[] arr2 = {5, 4, 2, 1, 7, 0, -1, -4, 12};
        int[] arr3 = {2, 3, 0, 1};
        out.println(median(arr2) == 2);    // Calculate median of elements
        out.println(median(arr3) == 1.5);

        int[] arr4 = {2, 3, 0, 1, 5, 4};
        int[] arr5 = {5, 4, 2, 2, 1, 7, 4, 0, -1, -4, 0, 0, 12};
        out.println(kSmallest(arr4, 2) == 1);   // Second smallest is 1
        out.println(kSmallest(arr5, 5) == 2);   // 5th smallest is 2

    }

    // ---------- Write methods here --------------

    private boolean isSorted ( int[]arr ) {
        for ( int i = 0; i < arr.length -1; i++ ) {
            if ( arr[i] > arr[i+1] ) {
                return false;
            }
        }
        return true;
    }


    private void sort ( int[]array ) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }


    private double median ( int[]arr ) {
        double median;
        sort(arr);

        if ( arr.length % 2 == 0 ) {
            median = ((double)arr[arr.length/2] + (double)arr[arr.length/2 - 1])/2;
        } else {
            median = (double) arr[arr.length/2];
        }
        return median;
    }


    private int kSmallest ( int[]arr, int nbr ) {
        int kthSmallest = 0;
        int[]arr2;

        sort(arr);

        arr2 = removeDupl(arr);

        for ( int i = 0; i < nbr; i++ ) {
            kthSmallest = arr2[i];
        }

        return kthSmallest;
    }


    int[] removeDupl(int[] arr) {
        int count = 0;
        int save = -1;

        for (int m = 0; m < arr.length; m++) {
            if (arr[m] != save) {
                count++;
                save = arr[m];
            }
        }

        int[] array2 = new int[count];
        int save2 = -1;
        int i = 0;

        for (int n = 0; n < arr.length; n++) {
            if (arr[n] != save2) {
                array2[i] = arr[n];
                save2 = arr[n];
                i++;
            }
        }
        return array2;
    }


}
