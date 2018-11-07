package samples;

import java.util.Scanner;    // Need this from Java

import static java.lang.System.*; // Need this from Java

/**
     Input output
 */
public class IO {

    public static void main(String[] args) {
        new IO().program();
    }

    void program() {

        // Use out stream
        //out.print(1);           // Print literal 1 to screen  (NO new line)
        //out.println("abc");     // Print String literal and then new line
        //out.println(" c d e "); // Print String literal, spaces preserved

        // Use in-stream + Scanner
        Scanner scan = new Scanner(in);  // Create Scanner, connect scanner and in stream

        // Must have some place to store input value, use a variable (with type integer)
        int value;

        // Use Scanner to scan in stream for data (and if possible convert)
        // If not possible to convert, an exception and program aborted
        value = scan.nextInt();      // Read an int into variable value (program waits until Enter)

        out.println("value was " + value);  // Use + to concatenate string and value
       
    }
}
