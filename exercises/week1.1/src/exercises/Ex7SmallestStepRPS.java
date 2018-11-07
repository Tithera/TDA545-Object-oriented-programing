package exercises;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * Applying "smallest step tactics" to Rock, paper, scissor game.
 * See https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors
 *
 * Rules:
 *
 *       -----------  Beats -------------
 *       |                              |
 *       V                              |
 *      Rock (1) --> Scissors (2) --> Paper (3)
 *
 * See:
 * - SmallestStepNim
 *
 */
public class Ex7SmallestStepRPS {

    public static void main(String[] args) {
        new Ex7SmallestStepRPS().program();
    }

    final Random rand = new Random();
    final Scanner sc = new Scanner(in);

    void program() {

        int maxRounds = 5;
        int human;          // Outcome for player
        int computer;       // Outcome for computer
        int round = 0;      // Number of rounds
        int total = 0;      // Final result after all rounds


        out.println("Welcome to Rock, Paper and Scissors");

        // Write code for game here

        while ( round < maxRounds ) {

            //Input
            out.print("Select 1, 2 or 3 (for R, P or S) > ");
            human = sc.nextInt();

            computer = rand.nextInt(3) + 1;
            out.println("Computer took: " + computer);


            //Process
            if ( human == computer ) {

                out.println("A draw");
                out.println("Result is " + total);

            } else if ( human == 3 && computer == 1 || human < computer) {

                out.println("Human won");
                total = total + 1;
                out.println("Result is " + total);

            } else if ( computer == 3 && human == 1 || computer < human) {

                out.println("Computer won");
                total = total - 1;
                out.println("Result is " + total);

            }

            round = round + 1;
        }

        //Output
        out.println("Game over! ");
        if (total == 0) {
            out.println("Draw");
        } else if (total > 0) {
            out.println("Human won.");
        } else {
            out.println("Computer won.");
        }
    }
}
