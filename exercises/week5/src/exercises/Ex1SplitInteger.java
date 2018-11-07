package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import static java.lang.System.lineSeparator;
import static java.lang.System.out;

/*
    The fascinating problem of splitting an int into a sum of n (random selected) int's
    See Wikipedia: Combinations
 */

public class Ex1SplitInteger {

    Random rd = new Random();

    public static void main(String[] args) {
        new Ex1SplitInteger().program();
    }

    private void program() {
        final int n = 7;     // The number to split, could vary, try 146
        final int b = 4;     // How many parts to split into, could vary, try 17

        for (int i = 0; i < 10; i++) {
            int[] split = splitInt(n, b);
            out.print(Arrays.toString(split));
            out.println( split.length == b && sum(split) == n);  // All should print true
        }

    }

    // Test Helper
    int sum( int[] arr){
        int s = 0 ;
        for( int i : arr){
            s += i;
        }
        return s;
    }

    // ----------- Methods here ---------------------------------------

    int[] splitInt ( int nbrToSplit, int partsToSplit ) {
        int valueLeft = partsToSplit;
        int nbrToSplitLeft = nbrToSplit;
        int randNbr;

        int[] arrSplit = new int[partsToSplit];

        while ( valueLeft > 0  ) {

            randNbr = rd.nextInt(7);

            if ( randNbr <= nbrToSplitLeft ) {
                arrSplit[valueLeft-1] = randNbr;
                nbrToSplitLeft = nbrToSplitLeft - randNbr;
                valueLeft--;
            }
        }

        if (sum(arrSplit) != nbrToSplit) {
            int whatsLeft = nbrToSplit - sum(arrSplit);
            arrSplit[arrSplit.length-1] = arrSplit[arrSplit.length-1] + whatsLeft;
        }

        return arrSplit;
    }

}
