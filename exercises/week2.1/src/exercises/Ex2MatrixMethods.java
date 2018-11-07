package exercises;

import java.util.Arrays;

import static java.lang.StrictMath.round;
import static java.lang.StrictMath.sqrt;
import static java.lang.System.out;

/*
 * Methods with array/matrix params and/or return value. Implement methods.
 *
 * See:
 * - Matrices
 */

public class Ex2MatrixMethods {

    public static void main(String[] args) {
        new Ex2MatrixMethods().program();
    }

    void program() {
        int[][] m = {           // Hard coded test data
                {-1, 0, -5, 3},
                {6, 7, -2, 0},
                {9, -2, -6, 8},
                {0, 0, 5, -6}
        };

        // TODO uncomment one at a time and implement

        // Return array with all negatives in m
        int[] negs = getNegatives(m);
        out.println(negs.length == 6);
        out.println(Arrays.toString(negs).equals("[-6, -6, -2, -2, -5, -1]")); // Possibly other ordering!

        // Mark all negatives with a 1, others as 0 (create matrix on the fly)
        int[][] marked = markNegatives(new int[][]{
                {1, -2, 3,},
                {-4, 5, -6,},
                {7, -8, 9,},
        });

        /* marked should be
        { {0, 1, 0},
          {1, 0, 1},
          {0, 1, 0} }
        */

        out.println(Arrays.toString(marked[0]).equals("[0, 1, 0]"));
        out.println(Arrays.toString(marked[1]).equals("[1, 0, 1]"));
        out.println(Arrays.toString(marked[2]).equals("[0, 1, 0]"));

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Create matrix from array
        int[][] matrix = toMatrix(arr);
        /* matrix should be
        { {1, 2, 3},
          {4, 5, 6},
          {7, 8, 9} }
        */

        plot(matrix);  // If manual inspection

        out.println(Arrays.toString(matrix[0]).equals("[1, 2, 3]"));
        out.println(Arrays.toString(matrix[1]).equals("[4, 5, 6]"));
        out.println(Arrays.toString(matrix[2]).equals("[7, 8, 9]"));


        // Sum of all directly surrounding elements to some element in matrix
        // (not counting the element itself)
        // NOTE: Should be possible to expand method to include more distant neighbours

        out.println(sumNeighbours(matrix, 0, 0) == 11);
        out.println(sumNeighbours(matrix, 1, 1) == 40);
        out.println(sumNeighbours(matrix, 1, 0) == 19);

    }

    // -------- Write methods below this -----------------------

    private int[] getNegatives ( int[][] matrix) {
        int count = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if ( matrix[row][col] < 0 ) {
                    count++;
                }
            }
        }

        int[] array = new int[count];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if ( matrix[row][col] < 0 ) {
                    array[count-1] = matrix[row][col];
                    count--;
                }
            }
        }
        return array;
    }


    private int[][] markNegatives ( int[][]matrix ) {

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                if ( matrix[row][col] < 0 ) {
                    matrix[row][col] = 1;
                } else {
                    matrix[row][col] = 0;
                }
            }
        }
        return matrix;
    }


    private int[][] toMatrix ( int[] array ) {

        double lenghtArray = array.length / sqrt(array.length);
        int count = 0;

        int[][] matrix = new int[(int)lenghtArray][(int)lenghtArray];

        for ( int row = 0; row < matrix.length; row++ ) {
            for ( int col = 0; col < matrix[row].length; col++ ) {

                matrix[row][col] = array[count];
                count++;
            }
        }
        return matrix;
    }


    private int sumNeighbours ( int[][]matrix, int row, int col ) {

        int[][] positions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int sum = 0;

        for (int j = 0; j < positions.length; j++) {
            int newCol = col + positions[j][0];
            int newRow = row + positions[j][1];

            if ( isValidPosition(col, newCol, newRow, matrix) ) {
                sum = sum + matrix[newCol][newRow];
            }
        }
        return sum;
    }

    //Checks if the position exists
    private boolean isValidPosition(int col, int newCol, int newRow, int[][]matrix) {
        return newCol >= 0 && newCol < matrix.length && newRow >= 0 && newRow < matrix[col].length;
    }


    // Use if you like (during development)
    void plot(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            out.println(Arrays.toString(matrix[row]));
        }
    }

}
