package samples;

import java.util.*;

import static java.lang.System.*;

/*
   Remove from a Collection
   Some things to look after (not needed for exercises but possible in labs)
 */
public class RemoveFromCollection {

    public static void main(String[] args) {
        new RemoveFromCollection().program();
    }

    private void program() {
        Integer[] is = {1, 0, -1, 1, 0, -1, 0, 1};
        // Arrays.asList() returns an unmodifiable List, can't use directly
        List<Integer> l = new ArrayList<>(Arrays.asList(is));


        // NO! Concurrent modification exception if using short for loop
        /*for (Integer i : l) {
            if (i < 0) {
                l.remove(i);
            }
        }*/

        // Ok! Use normal for-loop
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) < 0) {
                // l.remove(i);           // Remove by index ...
                l.remove(l.get(i));  // ... or remove by object
            }
        }
        out.println(l.toString());


        // Also possible
        List<Integer> tmp = new ArrayList<>();  // Temporary list
        for (Integer i : l) {
            if (i == 0) {
                tmp.add(i); // Store for later removal
            }
        }
        l.removeAll(tmp);  // Now remove them all (outside loop)

        out.println(l.toString());

    }
}
