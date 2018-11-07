package exercises;

import java.util.Scanner;

import static java.lang.System.*;;

/*
 * Program to calculate sum and average for non-negative integers
 *
 * See:
 * - Loops (while only)
 * - LoopAndAHalf
 *
 */
public class Ex3SumAvg {

    public static void main(String[] args) {
        new Ex3SumAvg().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        //Declaring variables
        double nbr;
        int count = 0;
        double sum = 0;
        double avg;


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
