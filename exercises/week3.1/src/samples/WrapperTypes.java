package samples;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.*;
import static java.lang.Math.*;

/*
 *  Wrapper types
 *
 *  A wrapper type is a reference version of a primitive type i.e an object holding a single
 *  immutable primitive value. Conversion between primitive type and reference type is done automatically.
 *
 *  Boxing conversion = from primitive to reference
 *  Unboxing conversion = from reference to primitive
 *
 */
public class WrapperTypes {

    public static void main(String[] args) {
        new WrapperTypes().program();
    }

    final Random rand = new Random();

    void program() {
        Integer i = 4;   // Conversion from int (4) to Integer (boxing)...
        int j = i;        // ... and back (unboxing)
        int[] k = {1, 2, 3};

        // Will convert int elements to Integer objects
        Integer[] iis = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        out.println(Arrays.toString(iis));

        // No automatic conversion of arrays, just single values
        // Integer[] is = k;

        out.println(i.equals(4)); // Wrapper types are objects have methods
        //out.println(j.equals(4)); // No! Primitive type

        // Other wrapper types
        Boolean b = true;
        Character c = 'q';
        Double d = 3.4;


        // Arrays and bad type conversions, below
        int[] iArr = {1, 2, 3};

        // Error, no implicit casting (of elements)
        // double[] dArr = iArr;

        // Error, no explicit casting
        // dArr = (double[]) iArr;

        // Error! no implicit casting to reference
        // elements
        // Integer[] iiArr = iArr;


    }


}
