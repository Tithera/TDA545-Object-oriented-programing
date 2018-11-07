package exercises;

import java.util.Arrays;
import java.util.Random;

import static java.lang.StrictMath.round;
import static java.lang.System.*;

/*
 *  Methods with array params and/or return value. Implement methods.
 *
 *  See:
 *  - MathMethods
 *  - ArrayMethods
 */

public class Ex1ArrayMethods {

    public static void main(String[] args) {
        new Ex1ArrayMethods().program();
    }

    final static Random rand = new Random();

    void program() {
        int[] arr = {1, 2, 2, 5, 3, 2, 4, 2, 7};  // Hard coded test data

        // TODO uncomment one at a time and implement

        // Count occurrences of some element in arr
        out.println(count(arr, 2) == 4);      // There are four 2's
        out.println(count(arr, 7) == 1);

        // Generate array with 100 elements with 25% distribution of -1's and 1's (remaining will be 0)
        arr = generateDistribution(100, 0.25, 0.25);
        out.println(count(arr, 1) == 25);
        out.println(count(arr, -1) == 25);
        out.println(count(arr, 0) == 50);

        for (int i = 0; i < 100; i++) {
            // Random reordering of arr, have to check by inspecting output
            shuffle(arr);
            out.println(Arrays.toString(arr));  // Does it look random?
        }

    }

    // ---- Write methods below this ------------

    private int count (int[] arr, int nbr) {
        int count = 0;

        for ( int i = 0; i < arr.length; i++ ) {

            if ( arr[i] == nbr ) {
                count++;
            }
        }
        return count;
    }


    private int[] generateDistribution (int nbrInArr, double distrMinus1, double distrPlus1) {

        int[] arr = new int[nbrInArr];
        int count = nbrInArr - 1;
        int randNbr;
        double calcDistrMinus1;
        double calcDistrPlus1;
        double zeros = nbrInArr;

        calcDistrMinus1 = distrMinus1 * nbrInArr;
        calcDistrPlus1 = distrPlus1 * nbrInArr;
        zeros = zeros - calcDistrMinus1 - calcDistrPlus1;

        calcDistrMinus1 = round(calcDistrMinus1);
        calcDistrPlus1 = round(calcDistrPlus1);
        zeros = round(zeros);

        while ( count >= 0 ) {

            randNbr = rand.nextInt(1 + 1 + 1 ) - 1;

            if ( randNbr == -1 && calcDistrMinus1 > 0 ) {

                arr[count] = -1;
                calcDistrMinus1--;

            } else if ( randNbr == 1 && calcDistrPlus1 > 0 ) {

                arr[count] = 1;
                calcDistrPlus1--;

            } else if ( randNbr == 0 && zeros > 0) {

                arr[count] = 0;
                zeros--;

            }
            count = count - 1;
        }
        return arr;
    }


    private int[] shuffle (int[] array) {
        int temp;
        int randPlace;
        int randPlace2;
        int arrLength = array.length;

        for ( int i = 0; i < array.length; i++ ) {

            randPlace = rand.nextInt(arrLength) + 1;
            randPlace2 = rand.nextInt(arrLength) + 1;

            temp = array[randPlace-1];
            array[randPlace-1] = array[randPlace2-1];
            array[randPlace2-1] = temp;

        }
        return array;
    }

}
