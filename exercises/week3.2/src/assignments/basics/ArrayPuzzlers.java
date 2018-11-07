package assignments.basics;

import java.util.Arrays;

import static java.lang.System.*;

/*
 * Some array puzzlers
 */
public class ArrayPuzzlers {


    public static void main(String[] args) {
        new ArrayPuzzlers().program();
    }

    void program() {
        // This is testing. expected outcome as commented
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {1, 2, 2, 3, 3};

        out.println(Arrays.toString(arr1));  // [1, 2, 3, 4, 5, 6, 7, 8]
        rotate(arr1, 3);
        out.println(Arrays.toString(arr1));  //[6, 7, 8, 1, 2, 3, 4, 5]

        out.println(Arrays.toString(arr2));   // [1, 2, 2, 3, 3]
        out.println(Arrays.toString(removeDupl(arr2)));  // [1, 2, 3]
        out.println(Arrays.toString(arr2));  // [1, 2, 2, 3, 3]

    }


    // Rotate all elements in arr k steps to the right (in a circular fashion)
    void rotate(int[] arr, int k) {
        int save;

        for ( int i = 0; i < k; i++ ) {

            save = arr[arr.length-1];

            for ( int j = arr.length-1; j >= 0; j-- ) {

                if ( j == 0 ) {

                    arr[j] = save;

                } else {

                    arr[j] = arr [j-1];

                }

            }

        }

    }


    // Remove all duplicates from arr (original unchanged, copy created)
    // NOTE: We assume the array is sorted in ascending order	
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

