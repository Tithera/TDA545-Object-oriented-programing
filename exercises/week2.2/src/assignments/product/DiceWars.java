package assignments.product;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;
import static java.lang.Math.*;

/*
 * Simplified text based (i.e. non graphical) version of the Dice Wars game
 * For a full graphical version, see http://www.gamedesign.jp/flash/dice/dice.html (or other)
 *
 * Some rule simplification
 * - No limit of dices in a country
 * - Distribution of earned dices may be "somewhat" random.
 * - Game over when a player lost all countries
 * - Player with most countries wins (or dices? or a combination? You find a measure)
 *
 *  Plan and Process: Compare Tic Tac Toe from exercises
 */
public class DiceWars {
    Random rand = new Random();
    Scanner sc = new Scanner(in);
    int activePlayer = 0;

    public static void main(String[] args) {
        new DiceWars().program();
    }

    void program() {

        // The players of the game (mostly referenced by index)
        String[] players = {"Pelle", "Fia", "Lisa"};

        // A map with nine countries, named by their index (0-8). Leading 1:s because can't have leading 0 (just skip
        // the ones when processing). 114 says: The country 0 has border to countries 1 and 4.
        // Number of countries is a multiple of players, they all get the same numbers of countries
        int[] map = {114, 1024, 115, 146, 101357, 12487, 137, 14568, 157};

        // This is the owners of the countries. Country 0 is owned by player pelle (players[0])
        int[] owners = {0, 1, 2, 1, 2, 0, 0, 1, 2};

        // This is the number of dices for a country. Country 1 has 3 dices.
        int[] dices = {2, 3, 2, 3, 1, 3, 1, 1, 3};

        String action = null;
        int selectFrom = 0;
        int selectTo = 0;
        int winnerThisRound;
        int ownerToLand;


        //The game is starting
        out.println( "Welcome to Dice Wars \"lite!\"" );
        out.println();


        while ( !hasSomeoneWon( activePlayer, owners ) ) {

            plotMap(map, owners, dices, players);
            out.println();

            out.println( "It is " + players[getActivePlayer()] + " time to play" );

            out.print( "Action (a) or cancel (n) > " );

            action = sc.nextLine();

            if ( action.equals("a") ) {

                out.print( "Select from country > " );

                selectFrom = sc.nextInt();

                while ( (selectFrom < 0) || (selectFrom > 8) || activePlayer != owners[selectFrom] ) {

                    out.println( "You have to choose one of your own country and a country that exist, select from country > " );

                    selectFrom = sc.nextInt();

                }

                out.print( "Select country to attack > " );

                selectTo = sc.nextInt();

                while ( selectTo < 0 || selectTo > 8 || !hasBorder( selectFrom, selectTo, map ) || activePlayer == owners[selectTo] ) {

                    out.println( "You can't attack your own country or a country that does not exist, it also needs to " +
                            "have a border with the first country" );

                    out.println( "Select another country to attack > " );

                    selectTo = sc.nextInt();

                }

                winnerThisRound = calculateWar(selectFrom, selectTo, dices);

                ownerToLand = owners[winnerThisRound];

                out.println( "Winner this round is " + players[ownerToLand] );

                if ( ownerToLand == activePlayer ) {

                    changeOwner(selectTo, activePlayer, owners);

                    moveDices(selectFrom, selectTo, dices);

                } else {

                    getNewDices(activePlayer, dices, owners);

                    changePlayer(activePlayer, players);

                }


            } else if ( action.equals("n") ) {

                getNewDices(activePlayer, dices, owners);

                changePlayer(activePlayer, players);

            }

        }

        out.println("Game over");
        out.println("Winner is " + players[activePlayer]);

    }

    //The game is over


    // ---- Write your methods below this -----------------------------------

    // Start with this one! Is will say "yes" if two countries have a border
    boolean hasBorder(int i, int j, int[]map){

        int calculateWith = map[i];
        int compareTo = j;

        while ( calculateWith > 10) {

            calculateWith = calculateWith % 10;

            if ( compareTo == calculateWith ) {

                return true;

            }

            calculateWith = calculateWith / 10;

        }

        return false;

    }


    boolean hasSomeoneWon (int activeP, int[] owners) {

        for ( int i = 0; i < owners.length; i++ ) {

            if ( owners[i] != activeP ) {

                return false;

            }

        }

        return true;
    }


    int getActivePlayer () {

        return activePlayer;

    }


    int calculateWar (int selectFrom, int selectTo, int[] dices) {

        int diceFrom = dices[selectFrom];
        int diceTo = dices[selectTo];

        int diceFromMin = 1 * diceFrom;
        int diceFromMax = 6 * diceFrom;
        int diceToMin = 1 * diceTo;
        int diceToMax = 6 * diceTo;

        int randDiceFrom;
        int randDiceTo;

        randDiceFrom = rand.nextInt(diceFromMax) + diceFromMin;
        randDiceTo = rand.nextInt(diceToMax) + diceToMin;

        if ( randDiceFrom > randDiceTo ) {

            return selectFrom;

        } else if ( randDiceTo > randDiceFrom ) {

            return selectTo;

        } else if ( randDiceFrom == randDiceTo ) {

            return selectTo;

        }

        return 0;

    }


    void changeOwner (int selectTo, int activePlayer, int[] owners){

        owners[selectTo] = activePlayer;

    }


    void moveDices (int selectFrom, int selectTo, int[] dices) {

        int fromDices = dices[selectFrom];
        int calculateFrom = fromDices - 1;
        int newFromDice;

        out.print("Move between 0 and " + calculateFrom + " to the new country > ");

        newFromDice = sc.nextInt();

        while ( newFromDice < 0 || newFromDice > calculateFrom ) {

            out.print("Move between 0 and " + calculateFrom + " to the new country > ");

            newFromDice = sc.nextInt();

        }

        dices[selectFrom] = dices[selectFrom] - newFromDice;

        dices[selectTo] = dices[selectTo] + newFromDice;

    }


    void getNewDices(int activeP, int[] dices, int[] owners) {

        int nbrOfDices = 0;
        int randDices = 0;
        int ownerCountry = 0;

        for ( int i = 0; i < owners.length; i++ ) {

            if ( owners[i] == activeP ) {

                nbrOfDices = nbrOfDices + 1;

            }

        }

        while ( nbrOfDices > 0 ) {

            for (int k = 0; k < owners.length; k++) {

                if (activeP == owners[k]) {

                    randDices = rand.nextInt((nbrOfDices) + 1);

                    dices[k] = dices[k] + randDices;

                    nbrOfDices = nbrOfDices - randDices;

                    if (nbrOfDices < 1) {
                        break;
                    }

                }

            }

        }


    }


    int changePlayer (int activeP, String[]players) {

        if ( activeP == players.length - 1 ) {

            activePlayer = 0;

            return activePlayer;

        } else {

            activePlayer = activeP + 1;

            return activePlayer;

        }

    }


    // ----  Nothing to do for you below this line  -----

    // Plot map (as a graph) using ASCII chars
    void plotMap(int[] map, int[] owners, int[] dices, String[] players) {
        int n = (int) sqrt(map.length);
        for (int row = 0; row < 2 * n - 1; row += 2) {
            // One row with horizontal connections
            for (int col = 0; col < n; col++) {
                int i = 3 * row / 2 + col;
                out.print(players[owners[i]] + ":" + dices[i]);
                if (hasBorder(i, i + 1, map)) {
                    out.print("--");
                } else {
                    out.print("  ");
                }
            }
            out.println();
            // Another row with vertical connections
            for (int col = 0; col < n; col++) {
                int i = 3 * row / 2 + col;
                if (hasBorder(i, i + n, map)
                        && hasBorder(i, i + n - 1, map)
                        && hasBorder(i, i + n + 1, map)) {
                    out.print("  / | \\ ");
                } else if (hasBorder(i, i + n, map)
                        && hasBorder(i, i + n - 1, map)) {
                    out.print("/  |     ");
                } else if (hasBorder(i, i + n, map)
                        && hasBorder(i, i + n + 1, map)) {
                    out.print("   | \\  ");
                } else if (hasBorder(i, i + n - 1, map)) {
                    out.print(" /      ");
                } else if (hasBorder(i, i + n + 1, map)) {
                    out.print("     \\  ");
                } else if (hasBorder(i, i + n, map)) {
                    out.print("   |    ");
                } else {
                    out.print("         ");
                }
            }
            out.println();
        }
        out.println("-----------------------------------------");
    }
}
