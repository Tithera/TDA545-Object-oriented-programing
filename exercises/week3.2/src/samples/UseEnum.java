package samples;

import static java.lang.System.out;

/*
 * Using enums for (type safety)
 */

public class UseEnum {

    public static void main(String[] args) {
        new UseEnum().program();
    }

    // A new reference type
    enum WeekDay {
        MON, TUE, WED, THU, FRI, SAT, SUN
    }

    void program() {
        WeekDay d1 = WeekDay.FRI;
        WeekDay d2 = WeekDay.THU;
        Object o = d2;  // OK

        //WeekDay d3 = "SUN";    // No SUN is a string, wrong type
        WeekDay d4 = WeekDay.FRI;

        out.println(d1 != d2);
        out.println(d1 == d4);

        WeekDay[] days = WeekDay.values();
        for (WeekDay w : days) {
            out.println(w);  // Have toString method
        }

        WeekDay d5 = WeekDay.valueOf("SUN");  // String must be exactly as enum  "SUN" <-> SUN
    }
}



