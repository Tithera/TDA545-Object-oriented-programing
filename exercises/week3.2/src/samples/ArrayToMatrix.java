package samples;

import java.util.Arrays;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.System.out;

/**
 * Converting from Array to matrix (2d Array)
 */
public class ArrayToMatrix {

    public static void main(String[] args) {
        new ArrayToMatrix().program();
    }

    void program() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] matrix = toMatrix(arr);
        plot(matrix);

    }

    int[][] toMatrix(int[] arr) {
        int size = (int) round(sqrt(arr.length));
        int[][] matrix = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            matrix[i / size][i % size] = arr[i];
        }
        return matrix;
    }

    void plot(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            out.println(Arrays.toString(matrix[row]));
        }
    }

}
