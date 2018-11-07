package assignments.product;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 * Nim Game
 * See https://en.wikipedia.org/wiki/Nim
 *
 * Plan and process: Compare Rock, Paper Scissor from exercises !
 */
public class Nim {

    public static void main(String[] args) {
        new Nim().program();
    }

    void program() {

        //Declaring variables
        int coins = 13;
        int tookCoin;
        boolean humanTurn = true;

        Scanner sc = new Scanner(in);
        Random rand = new Random();

        out.println( "Welcome to NIM" );
        out.println( "There's " + coins + " coins in the pile" );

        //Tredje försöket
        while ( coins > 0 ) {

            if ( humanTurn ) {

                out.print( "Pick coin (between 1-3) > " );
                tookCoin = sc.nextInt();

                while ( tookCoin > 3 || tookCoin < 1 ) {
                    out.print( "You have to pick a number between 1-3, pick again > " );
                    tookCoin = sc.nextInt();
                }

            } else {

                tookCoin = rand.nextInt(3) + 1;

            }

            out.println((humanTurn ? "Human" : "Computer") + " took " + tookCoin + " coins");

            coins = coins - tookCoin;
            out.println("There's " + coins + " coins in the pile");

            humanTurn = !humanTurn;
        }

        //Output
        if ( humanTurn ) {
            out.println("Game over. Winner is: Human");
        } else {
            out.println("Game over. Winner is: Computer");
        }

    }
}
