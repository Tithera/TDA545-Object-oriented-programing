package samples;

import static java.lang.System.*;

/**
 * Simple methods (run debugger to see)
 */
public class Methods {


    public static void main(String[] args) {
        new Methods().program();
    }

    void program() {
        int result = 0;

        result = add(1, 2);   // Call
        out.println("Result was " + result);

        out.println(isEven(5));      // Call
        out.println(realDiv(11, 3));  // Call
        out.println(sumTo(3));       // Call

        printIt(6.3);    // Call
    }

    // Declaration
    int add(int a, int b) {
        int result = a + b;
        return result;
    }

    // Declaration
    boolean isEven(int n) {
        return n % 2 == 0;
    }

    // Declaration
    double realDiv(double nom, double denom) {
        return nom / denom;
    }

    // Declaration
    int sumTo(int n) {
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    // Void method doesn't return anything
    void printIt(double d) {
        out.println("It is " + d);
    }
}
