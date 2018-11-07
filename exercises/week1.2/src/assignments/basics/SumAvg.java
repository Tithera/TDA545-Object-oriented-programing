package assignments.basics;

import java.util.Scanner;
import static java.lang.System.*;

/*
 * Sum and average for integers
 */
public class SumAvg {

    public static void main(String[] args) {
        new SumAvg().program();
    }

    void program() {
        // Write your code here

        //Declaring variables
        double nbr;
        int count = 0;
        double sum = 0;
        double avg;

        Scanner sc = new Scanner(in);

        while ( count >= 0 ) {

            //Input
            out.print("Write a number (negative nbr to cancel) > ");
            nbr = sc.nextInt();

            //Process
            if (nbr >= 0) {
                sum = sum + nbr;
            } else if ( nbr < 0 ) {
                break;
            }
            count++;
        }

        avg = sum / count;

        //Output
        out.println("Count = " + count + " Sum = " + sum + " Avg = " + avg);

    }
}