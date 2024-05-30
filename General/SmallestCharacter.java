/* Minimum Ascii valued character in a String */

public class SmallestCharacter {
    public static void main(String[] args) {
        String s = "rbijit";

        int min = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i);
            if (n < min) {
                min = n;
            }
        }

        char c = (char) min;
        System.out.println(c);
    }
}