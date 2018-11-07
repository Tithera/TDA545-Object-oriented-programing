package exercises;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Program to exercise arrays
 * <p>
 * See:
 * - Loops (for-loop only)
 * - ArrayBasics

 Se Ex4Arrays. Implement a program like below. You should use an Array to store the values and
 for-loops to process.

 Input 5 integers (space between, then enter) > 4 2 6 1 9
 Array is [4, 2, 6, 1, 9]
 Input a value to find > 1
 Value 1 is at index 3         (if not found prints: Value not found)

 */
public class Ex4Arrays {

    public static void main(String[] args) {
        new Ex4Arrays().program();
    }

    final Scanner sc = new Scanner(in);

    private void program() {

        int[] array = new int[5];
        int valueInArray;
        int indexInArray = 0;
        boolean valueExist = false;

        //Input value for array
        out.print("Input 5 integers (space between, then enter) > ");

        for ( int i = 0; i < array.length; i++ ) {
            array[i] = sc.nextInt();
        }

        //Write out what you got from the user
        out.println(Arrays.toString(array));

        //Input value to find
        out.print("Input a value to find > ");
        valueInArray = sc.nextInt();

        for ( int j = 0 ; j < array.length; j++ ) {

            if ( array[j] == valueInArray ) {
                indexInArray = j;
                valueExist = true;
            }

        }

        if ( valueExist ) {
            out.println("Value " + valueInArray + " is at index " + indexInArray);
        } else {
            out.println("Value not found");
        }

    }

}
