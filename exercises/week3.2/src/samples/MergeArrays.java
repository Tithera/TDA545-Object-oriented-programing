package samples;

import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.System.*;

/**
 * Using array as objects (explicit instantiate)
 */
public class MergeArrays {

    public static void main(String[] args) {
        new MergeArrays().program();
    }

    void program() {
        int[] i1 = {5, 4, 2, 1, 7};
        int[] i2 = {8, 3, 8};

        sort(i1);

        int[] r1 = merge(i1, i2);
        out.println(Arrays.toString(r1));
        int[] r2 = merge(i1, i2);
        out.println(Arrays.toString(r2));
    }

    // Merge two arrays
    int[] merge(int[] a, int[] b) {

        sort(a);
        sort(b);

        int[] result = new int[a.length + b.length];  // <--------------------- HERE!!
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k] = a[i];
                i++;
            } else {
                result[k] = b[j];
                j++;
            }
            k++;
        }

        // If b shorter
        while (i < a.length) {
            result[k] = a[i];
            i++;
            k++;
        }

        // If a shorter
        while (j < b.length) {
            result[k] = b[j];
            j++;
            k++;
        }

        return result;
    }

    // Bubble sort
    void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                //out.println(j + ":" + (j+1));
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                //out.println(Arrays.toString(arr));
            }
        }
    }

    // Bubble sort again (original array NOT lost)
    int[] sort2(int[] arr) {
        int[] a = new int[arr.length];         // Make a copy
        for (int i = 0; i < a.length; i++) {
            a[i] = arr[i];
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return a;   // return the copy
    }

    int[] merge2(int[] a, int[] b) {
        return sort2(concat(a, b));
    }


    int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            result[k] = a[i];
            k++;
        }
        for (int i = 0; i < b.length; i++) {
            result[k] = b[i];
            k++;
        }
        return result;
    }

}
