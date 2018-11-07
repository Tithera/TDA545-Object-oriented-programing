package exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Use a stack to check parentheses, balanced and nesting. The parentheses are: (), [] and {}
 *
 *  See:
 *  - UseAStack
 */

public class Ex4CheckParen {

    public static void main(String[] args) {
        new Ex4CheckParen().program();
    }

    void program() {
        // All should be true
        out.println(checkParentheses("()"));
        out.println(checkParentheses("(()())"));
        out.println(!checkParentheses("(()))")); // Unbalanced
        out.println(!checkParentheses("((())")); // Unbalanced

        out.println(checkParentheses("({})"));
        out.println(!checkParentheses("({)}"));  // Bad nesting
        out.println(checkParentheses("({} [()] ({}))"));
        out.println(!checkParentheses("({} [() ({)})"));  // Unbalanced and bad nesting
    }

    // Can handle {}, () and []
    boolean checkParentheses(String expr) {
        Deque<Character> stack = new ArrayDeque<>();
        char matchingChar;

        char[] charArr = expr.toCharArray();

        for (char aCharArr : charArr) {

            if (aCharArr == '(' || aCharArr == '{' || aCharArr == '[') {
                stack.push(aCharArr);

            } else {

                try {
                    matchingChar = matching(aCharArr);
                } catch (IllegalArgumentException e) {
                    continue;
                }

                try {
                    if (stack.peek() == matchingChar) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } catch (NullPointerException e) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    // This is interesting because have to return, but what if no match?!?
    char matching(char ch) {
        //char c =  must initialize but to what?!
        switch (ch) {
            case ')':
                return '(';  // c = '('
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                // return c;
                throw new IllegalArgumentException("No match found");
        }
    }
}
