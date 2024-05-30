/* Remove Vowel From A String

 * Input : Arijit Ghosh
 * Output : rjt Ghsh
 */

import java.util.HashSet;

public class RemoveVowel {
    public static void main(String[] args) {
        String str = "Mohitur RahamAn";
        System.out.println(removeVowel(str));
    }

    public static String removeVowel(String str) {
        String ans = "";

        for (int i = 0; i < str.length(); i++) {
            if (!isVowel(str.charAt(i))) {
                ans += str.charAt(i);
            }
        }

        return ans;
    }

    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }

        return false;
    }
}