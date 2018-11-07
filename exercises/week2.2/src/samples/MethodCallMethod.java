package samples;

import static java.lang.System.*;

/**
 * Methods calling other methods and call stack
 * Run with debugger and inspect call stack (use IntelliJ)
 */
public class MethodCallMethod {


    public static void main(String[] args) {
        new MethodCallMethod().program();
    }

    void program() {
        printIt(addSquares(1, 2));
    }

    int addSquares(int a, int b) {
        return square(a) + square(b);
    }

    int square(int a) {
        return a * a;
    }

    // Void method doesn't return anything
    void printIt(int i) {
        out.println("Result = " + i);
    }

}
