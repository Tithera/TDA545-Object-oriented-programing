package exercises;

import java.util.Arrays;
import static java.lang.System.out;

/*
 *  Argots, silly secret languages
 *  See https://en.wikipedia.org/wiki/Argot
 *
 *  See:
 *  - UseCharacter
 *  - UseString
 * -  UseStringBuilder
 */
public class Ex2Argots {

    public static void main(String[] args) {
        new Ex2Argots().program();
    }

    void program() {
        out.println(toRobber("jag talar rövarspråket").equals("jojagog totalolaror rorövovarorsospoproråkoketot"));

        out.println(toRobber("i speak robber language").equals("i sospopeakok rorobobboberor lolanongoguagoge"));

        out.println(toPigLatin("my name is eric").equals("ymay amenay isway ericway"));

    }

    // ---------- Methods --------------------

    private String toRobber ( String str ) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = str.toCharArray();

        for ( int i = 0; i < charArr.length; i++ ) {

            if ( charArr[i] == 'b' || charArr[i] == 'c' || charArr[i] == 'd' || charArr[i] == 'f' || charArr[i] == 'g'
                    || charArr[i] == 'h' || charArr[i] == 'j' || charArr[i] == 'k' || charArr[i] == 'l' ||
                    charArr[i] == 'm' || charArr[i] == 'n' || charArr[i] == 'p' || charArr[i] == 'q' || charArr[i] == 'r'
                    || charArr[i] == 's' || charArr[i] == 't' || charArr[i] == 'v' || charArr[i] == 'w' || charArr[i] == 'x'
                    || charArr[i] == 'z' ) {

                sb = sb.append(charArr[i]).append('o').append(charArr[i]);

            } else if ( charArr[i] == 'a' || charArr[i] == 'e' || charArr[i] == 'i' || charArr[i] == 'o' || charArr[i] == 'u'
                    || charArr[i] == 'å' || charArr[i] == 'ä' || charArr[i] == 'ö' ) {

                sb = sb.append(charArr[i]);

            } else if ( charArr[i] == ' ' ) {

                sb = sb.append(charArr[i]);
            }
        }
        String s = sb.toString();
        return s;
    }


    private String toPigLatin ( String str ) {
        String s;
        StringBuilder sb = new StringBuilder();

        String[] stringArr = str.split(" ");

        for ( int j = 0; j < stringArr.length; j++ ) {
            char[] stringToChar = stringArr[j].toCharArray();

            if (stringToChar[0] == 'b' || stringToChar[0] == 'c' || stringToChar[0] == 'd' || stringToChar[0] == 'f' ||
                    stringToChar[0] == 'g' || stringToChar[0] == 'h' || stringToChar[0] == 'j' || stringToChar[0] == 'k'
                    || stringToChar[0] == 'l' || stringToChar[0] == 'm' || stringToChar[0] == 'n' || stringToChar[0] == 'p'
                    || stringToChar[0] == 'q' || stringToChar[0] == 'r' || stringToChar[0] == 's' || stringToChar[0] == 't'
                    || stringToChar[0] == 'v' || stringToChar[0] == 'w' || stringToChar[0] == 'x' || stringToChar[0] == 'z') {

                char temp = stringToChar[0];
                for (int m = 0; m < stringToChar.length; m++) {

                    if ( m == stringToChar.length - 1) {
                        stringToChar[stringToChar.length - 1] = temp;
                    } else {
                        stringToChar[m] = stringToChar[m + 1];
                    }
                }
                s = String.valueOf(stringToChar);
                sb = sb.append(s).append("ay");

            } else if (stringToChar[0] == 'a' || stringToChar[0] == 'e' || stringToChar[0] == 'i' || stringToChar[0] == 'o' ||
                    stringToChar[0] == 'u' || stringToChar[0] == 'å' || stringToChar[0] == 'ä' || stringToChar[0] == 'ö') {

                s = String.valueOf(stringToChar);
                sb = sb.append(s).append("way");
            }
            sb = sb.append(" ");
        }
        sb = sb.deleteCharAt(sb.length()-1);
        String st = sb.toString();
        return st;
    }

}
