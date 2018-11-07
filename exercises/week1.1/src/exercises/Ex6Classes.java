package exercises;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Using classes for compound data of different types that in
 *  some sense belongs together (may be same type).
 *  Here we describe a "hero" using a class.
 *
 * See:
 * - ClassBasics
 */

public class Ex6Classes {

    public static void main(String[] args) {
        new Ex6Classes().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        Hero h1 = new Hero();
        Hero h2 = new Hero();

        out.print("What's the name of the Hero 1? > ");
        h1.name = sc.nextLine();

        out.print("How strong is " + h1.name + " > ");
        h1.strength = sc.nextInt();


        sc.nextLine();
        out.print("What's the name of the Hero 2? > ");
        h2.name = sc.nextLine();

        out.print("How strong is " + h2.name + " > ");
        h2.strength = sc.nextInt();


        if ( h1.strength > h2.strength ) {
            out.print( h1.name + " is stronger");
        } else {
            out.print( h2.name + " is stronger");
        }

    }

    // ------ The class to use  -----------
    // A class for variables that describes a Hero
    class Hero {
        String name;
        int strength;
    }

}
