/*
 * You are given a string S consisting of lowercase letters. Your task is to remove all the consecutive duplicates from
 * the string and output the result. For example, if the input string is "abbcddeff", the output should be "abcdef".
 *
 * Input: abbcddeff
 * Output: abcdef
 */

import java.util.HashSet;

public class StringRemoveConsecutiveChars {
    public static void main(String[] args) {
        String s = "abbcddeff";
        System.out.println(removeConsecutiveChars(s));
    }

    public static String removeConsecutiveChars(String s) {
        String str = "";
        HashSet<Character> l = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if(!l.contains(s.charAt(i))) {
                l.add(s.charAt(i));
                str += s.charAt(i);
            }
        }

        return str;
    }
}