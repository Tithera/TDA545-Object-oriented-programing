package samples;

import java.util.Arrays;

import static java.lang.System.out;

/*
 * Overloading = Different method may have same name
 * Allowed only if the parameter list is different (types and/or number of args).
 *
 * Typical usage: Need to do same operation on arguments with different types
 */
public class Overloading {

    public static void main(String[] args) {
        new Overloading().program();
    }

    void program() {
        out.println(max(2, 3));
        out.println(max(-5.3, 4.06));

        out.println(max(3, 4.0));  // Hmm, which one called?

        int[] i = {1, 2, 3};
        int[] j = {4, 5, 6};
        out.println(Arrays.toString(max(i, j)));
    }

    int max(int i, int j) {
        return i > j ? i : j;   // An if *expression* i.e. a result is created
                                // If true return i else j
                                // The (normal) if-statement doesn't return anything!
    }

    double max(double i, double j) {  // Overloaded! Same name different arg types
        return i > j ? i : j;
    }

    int[] max(int[] i, int[] j) {           // Overloaded!
        // Assume i.length == j.length
        return sum(i) > sum(j) ? i : j;  // Our definition of max
    }

    int sum(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i];
        }
        return s;
    }
}

