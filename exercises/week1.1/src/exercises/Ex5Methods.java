package exercises;

import static java.lang.System.out;

/*
 *  Implement methods to make program produce correct output (print true)
 *
 * See:
 * - Methods
 */
public class Ex5Methods {

    public static void main(String[] args) {
        new Ex5Methods().program();
    }

    void program() {
        // All, except last,  should print true
        out.println(sumTo(5) == 15);     // 1 + 2 + ... + 5 = 15
        out.println(sumTo(23) == 276);
        out.println(factorial(3) == 6);    // 3 * 2 * 1 = 6
        out.println(factorial(5) == 120);
        out.println(digitSum(1111) == 4);   // 1 + 1 + 1 + 1 = 4
        out.println(digitSum(12345) == 15);

        int[] arr = {10, 20, 30, 40, 50};
        out.println(next(arr, 2) == 40);   // Find *next* value given index (in a circular fashion)
                                                  // Index 2 is 30 so next is 40.
        out.println(next(arr, 4) == 10);    // Index 4 is 50 so next is 10 (circular).

        // A special case, should print: "Winner is Olle" (or whatever name)
        winnerMsg("Olle");
    }

    // ------ Write methods below this  -----------

    private int sumTo (int nbr) {
        int totsum = 0;

        for (int i = 0; i <= nbr; i++) {
            totsum = totsum + i;
        }

        return totsum;
    }


    private int factorial (int nbr) {
        int totsum = 1;

        for (int j = nbr; j > 0; j--) {
            totsum = totsum * j;
        }

        return totsum;
    }


    private int digitSum (int nbr) {
        int calcSum = 0;
        int calcModulo;

        while (nbr > 0) {
            calcModulo = nbr % 10;
            calcSum = calcSum + calcModulo;
            nbr = nbr / 10;
        }

        return calcSum;
    }


    private int next (int[]arr, int nbr) {
        int nextValue = nbr;
        int returnValue;
        int[] array = arr;

        if ( nextValue == array.length-1 ) {
            nextValue = 0;
            returnValue = arr[nextValue];
        } else {
            returnValue = arr[nextValue+1];
        }

        return returnValue;
    }


    private void winnerMsg (String str) {
        out.print("Winner is " + str);
    }

}
