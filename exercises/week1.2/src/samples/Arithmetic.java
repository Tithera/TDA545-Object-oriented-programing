package samples;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * Arithmetic with Java
 */
public class Arithmetic {

    public static void main(String[] args) {
        new Arithmetic().program();
    }

    void program() {
        int op1;    // Declarations
        int op2;

        Scanner scan = new Scanner(in);

        out.print("Input 2 integers (enter after each) > ");  // Prompt user
        op1 = scan.nextInt();
        op2 = scan.nextInt();

        int result = op1 + op2;      // Declaration and initialization
        out.println("Result + " + result);

        result = op1 - op2;            // result already declared reuse
        out.println("Result - " + result);

        result = op1 * op2;
        out.println("Result * " + result);

        result = op1 / op2;              // Oh, oh, ..
        out.println("Result / " + result);  // ... this is integer division! (Both operands integer)

        double dResult = 1.0 * op1 / op2;   // 1.0 * op1 will be of type double thus real division used
        out.println("Result real / " + dResult);  // Real division

        result = op1 % op2;
        out.println("Result % (modulo) " + result);

        out.println("Left to right " + 4/2/2);   // Left to right
        out.println("Using parentheses " + 4/(2/2));


        // out.println("Div with zero " + 1/0);   // Arithmetic Exception
        out.println("Div with zero " + 1.0/0);    // Infinity
    }
}
