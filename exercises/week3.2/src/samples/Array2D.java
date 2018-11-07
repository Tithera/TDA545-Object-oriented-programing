package samples;

import static java.lang.System.*;
/**
 *  2 dimensional arrays
 */
public class Array2D {

    public static void main(String[] args) {
        new Array2D().program();
    }

    void program() {

        int[][] m = {               // An array of arrays
                { 1,2,3,},          // m[0]
                { 4,5,6,},          // m[1]
                { 7,8,9,},          // m[2]
        };

        printMatrix(m);

        int k = 0;
        int n[][] = new int[10][10];
        for(int row = 0 ; row < n.length ; row++){
            for( int col = 0 ; col < n[row].length; col++) {
                n[row][col] = k;
                k++;
            }
        }
        printMatrix(n);

    }

    // Will work for ragged matrices (but we only use rectangular/square)
    void printMatrix( int[][] m){
        // Traversing
        for(int row = 0 ; row < m.length ; row++){
            for( int col = 0 ; col < m[row].length; col++){
                out.print( m[row][col]);
            }
            out.println();
        }
    }
}
