package samples;

import java.util.HashMap;
import java.util.Map;
import static java.lang.System.out;

/**
 * A Map is a special type of data structure, like a dictionary.
 * Use it to look up values using a key
 *
 * NOTE: Map is a one way lookup: Given key, find value
 * No easy way to look up the other way round (value -> key)
 *
 * Map is the interface to use. One implementation is HashMap
 */

public class UseAMap {

    public static void main(String[] args) {
        new UseAMap().program();
    }

    void program() {
        // A Map with key type String and value Integer
        // NOTE Variable naming: name + Count (used for names + frequency of name)
        Map<String, Integer> nameCount = new HashMap<>();

        // Add frequency of names
        nameCount.put("fia", 23);
        nameCount.put("sven", 31);
        nameCount.put("lisa", 29);

        int nFia = nameCount.get("fia");  // Look frequency for fia
        out.println(nFia == 23);
        out.println(nameCount.get("sven") == 31);

        // Traversing
        for( String s: nameCount.keySet()){    // All keys
            out.println(s);
        }
        for( Integer i : nameCount.values()){    // All values
            out.println(i);
        }
        for( Map.Entry<String, Integer> e : nameCount.entrySet()){  // Both key and value, as a pair
            out.println(e.getKey() + ":" + e.getValue());
        }

        nameCount.remove("fia");
        out.println(nameCount.size() == 2);
    }

}
