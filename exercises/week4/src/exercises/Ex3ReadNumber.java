package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *   Extract numbers from Strings
 *   Argument 0 is index to start looking for digits.
 *   Return value is index directly after last read digit out.println(readNumber(numbers, "1", 0) == 1);
 *   The number should be in the list numbers (method should add number to list) out.println(numbers.contains("1"));
 *
 *   See:
 *  - UseCharacter
 *  - UseString
 *  - UseStringBuilder
 *  - UseAList
 */

public class Ex3ReadNumber {

    public static void main(String[] args) {
        new Ex3ReadNumber().program();
    }

    void program() {
        List<String> numbers = new ArrayList<>();

        out.println(readNumber(numbers, "1", 0) == 1);
        out.println(numbers.contains("1"));
        numbers.clear();
        out.println(readNumber(numbers, "123", 0) == 3);
        out.println(numbers.contains("123") && !numbers.contains("1"));
        numbers.clear();
        out.println(readNumber(numbers, "123abc", 0) == 3);
        out.println(numbers.contains("123"));
        numbers.clear();
        out.println(readNumber(numbers, "12345abc", 0) == 5);
        out.println(numbers.contains("12345"));
        numbers.clear();
        out.println(readNumber(numbers, "abc123abc", 3) == 6);
        out.println(numbers.contains("123"));

        // Empty string is not accepted will throw exception
        try {
            out.println(readNumber(numbers, "", 0) == 0);
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());
        }

    }

    private int readNumber(List<String> list, String str, int index) {
        StringBuilder sb = new StringBuilder();
        int i;
        char[] charArr = str.toCharArray();

        if (str.isEmpty()) {

            throw new IllegalArgumentException("String is empty");
        }

        for (i = index; i < charArr.length; i++) {

            if (Character.isDigit(charArr[i])) {
                sb.append(charArr[i]);
            } else {
                break;
            }
        }

        list.add(sb.toString());

        return i;
    }

}
