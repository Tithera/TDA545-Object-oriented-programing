package samples;

import java.util.Random;

import static java.lang.System.out;

/*
   Generic methods
 */

public class GenericMethod {

    public static void main(String[] args) {
        new GenericMethod().program();
    }

    public enum WeekDay {
        MON, TUE, WED, THU, FRI, SAT, SUN
    }
    public enum Color {
        RED, BLUE, YELLOW, GREEN, WHITE, BLACK
    }

    final Random rand = new Random();

    void program() {
        WeekDay[] days = { WeekDay.FRI, WeekDay.MON, WeekDay.THU};
        Color[] colors = { Color.BLACK, Color.BLUE, Color.GREEN};

        shuffle(colors);  // Ok
        shuffle(days);    // Ok

    }

    // Generic method works for any reference type
    <T> void shuffle(T[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i);
            T k = arr[i];
            arr[i] = arr[j];
            arr[j] = k;
        }
    }
}
