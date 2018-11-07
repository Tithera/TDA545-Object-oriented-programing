package samples;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;

/**
 * Fisher-Yates permutation algorithm (shuffle)
 */
public class FisherYates {

    public static void main(String[] args) {
        new FisherYates().program();
    }

    final static Random rand = new Random();

    void program() {
        int[] is = {1, 2, 3, 4, 5, 6};
        shuffle(is);
        out.println(Arrays.toString(is));
        shuffle(is);
    }

    // Will only work for int[]
    void shuffle(int[] is) {
        for (int i = is.length - 1; i > 0; i--) {
            int j = rand.nextInt(i);
            int ii = is[i];
            is[i] = is[j];
            is[j] = ii;
            out.println("Swap " + i + ":" + j + "-->" + Arrays.toString(is));
        }
    }
}
