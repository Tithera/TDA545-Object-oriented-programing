package samples;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 *  Convert Fahrenheit to Celsius
 */
public class F2C {

    public static void main(String[] args) {
        new F2C().program();
    }

    void program() {
        double fahrenheit;
        double celsius;
        Scanner sc= new Scanner(in);

        // Input
        out.print("Enter Fahrenheit > ");
        fahrenheit = sc.nextInt();     // Read an int ... (when running, write input in window below + Enter)

        // Process
        celsius = (fahrenheit - 32) * 5 / 9;    // .. will be converted to double

        // Output
        out.println( fahrenheit + " F = "  + celsius + " C");  // Output result
    }
}
