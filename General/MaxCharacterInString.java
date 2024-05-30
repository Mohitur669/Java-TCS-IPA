/* Find the Maximum Ascii valued character in a String
 * Arijit = t
 * priyanka = y
 * Aa = a
 */

public class MaxCharacterInString {
    public static void main(String[] args) {
        String s = "Mohitur";

        int max = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i);
            if (n > max ) {
                max = n;
            }
        }

        char ch = (char) max;
        System.out.println(ch);
    }   
}