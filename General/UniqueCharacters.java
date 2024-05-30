/*
Problem Statement
Write a Java program to print the unique characters present in the given string in the same sequence as they appear(the first occurrence) in the input.

Note:
All the characters should be in lowercase only.

i/p ->
xperience

o/p ->
xperinc
*/

import java.util.HashSet;

public class UniqueCharacters {
    public static void main(String[] args) {
        String s = "Xperience";
        System.out.println(uniqueCharacters(s));
    }

    public static String uniqueCharacters(String s) {
        s = s.toLowerCase();
        String str = "";
        HashSet<Character> h = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (!h.contains(s.charAt(i))) {
                h.add(s.charAt(i));
                str += s.charAt(i);
            }
        }

        return str;
    }
}