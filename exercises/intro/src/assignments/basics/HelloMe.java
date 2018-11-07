package assignments.basics;

import java.util.Scanner;

import static java.lang.System.in;

/*
 * A program that prints my name
 */
public class HelloMe {


    public static void main(String[] args) {
        new HelloMe().program();
    }

    private void program() {
        // Make program print "Hello" + you name here!
        // Example "Hello Sven"

        System.out.println("Write your name:");
        Scanner sc = new Scanner(in);

        String name;

        name = sc.nextLine();

        System.out.println("Hello " + name);

    }
}
