package exercises;

import java.util.Arrays;
import java.util.Random;
import static java.lang.StrictMath.round;
import static java.lang.System.out;

/*
 * Implement generic versions of shuffle and sort
 *
 *  See:
 *  - WrapperTypes
 *  - GenericMethod
 */

public class Ex6GenericMethods {

    public static void main(String[] args) {
        new Ex6GenericMethods().program();
    }

    final Random rand = new Random();

    void program() {
        // Working with wrapper types, generic methods only work with reference type
        Integer[] is = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String origIs = Arrays.toString(is);
        String[] ss = {"a", "b", "c", "d", "e"};
        String origSS = Arrays.toString(ss);

        // diffIndex works for all arrays reference types
        out.println(diffIndex(is, is) == -1);
        out.println(diffIndex(ss, ss) == -1);

        // shuffle should be a generic method, so we can use it for Integers ...
        shuffle(is);
        out.println(!Arrays.toString(is).equals(origIs));  // May be false, but unlikely
        // ... and here for String.
        shuffle(ss);
        out.println(!Arrays.toString(ss).equals(origSS));

        // sort should also be generic
        sort(is);
        out.println(Arrays.toString(is).equals(origIs));
        sort(ss);
        out.println(Arrays.toString(ss).equals(origSS));

    }

    // ------- Methods -------------------------

    <T> int diffIndex ( T[]arr1, T[]arr2 ) {
        int index = 0;
        for ( int i = 0; i < arr1.length; i++ ) {
            if ( arr1[i].equals(arr2[i]) ) {
                index = -1;
            } else {
                return i;
            }
        }
        return index;
    }


    <T> void shuffle ( T[]arrWithCell ) {
        T temp;
        int randPlace;
        int randPlace2;
        int arrLength = arrWithCell.length;

        for ( int i = 0; i < arrWithCell.length; i++ ) {

            randPlace = rand.nextInt(arrLength) + 1;
            randPlace2 = rand.nextInt(arrLength) + 1;

            temp = arrWithCell[randPlace-1];
            arrWithCell[randPlace-1] = arrWithCell[randPlace2-1];
            arrWithCell[randPlace2-1] = temp;
        }
    }


    <T extends Comparable> void sort ( T[]array ) {
        boolean swapped = true;
        int j = 0;
        T tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if ( array[i].compareTo(array[i + 1]) > 0 )  {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

}
