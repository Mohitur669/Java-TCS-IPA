/* Find the palindrome words from the sentence and print them and also count
 *
 * Input:
 * ----------------
 * My name is nitin and I can speak malayalam
 *
 * Output:
 * ----------------
 * nitin
 * I
 * malayalam
 * 3
 */

public class PalindromeFind {
    static int count = 0;

    public static void main(String[] args) {
        String s = "My name is nitin and I can speak malayalam";
        String[] arr = s.split(" ");

        for (String str : arr) {
            if (isPalindrome(str)) {
                count++;
                System.out.println(str);
            }
        }

        System.out.println(count);
    }

    public static boolean isPalindrome(String str) {
        String reverseString = reverse(str);
        if (str.equals(reverseString)) {
            return true;
        }
        return false;
    }

    static String reverse(String str) {
        String reverseString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseString = reverseString + str.charAt(i);
        }
        return reverseString;
    }
}