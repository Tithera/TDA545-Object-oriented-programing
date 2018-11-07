package assignments.product;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * Calculating a persons body mass index, BMI
 * See https://en.wikipedia.org/wiki/Body_mass_index
 *
 * bmi = weight / height²     (kg/m²)
 */
public class BMI {


    public static void main(String[] args) {
        new BMI().program();
    }

    void program() {
        // Write your code here

        //Declaring variables
        double weight;
        double height;
        double bmi;


        // Getting the weight
        out.print("Please, enter your weight (kg) > ");
        Scanner sc = new Scanner(in);
        weight = sc.nextDouble();


        // Getting the height
        out.print("Please, enter your height (m) > ");
        height = sc.nextDouble();


        //Calculating the bmi
        bmi = weight / ( height * height ) ;

        //Print out teh bmi
        out.println("BMI: " + bmi);

    }

}
