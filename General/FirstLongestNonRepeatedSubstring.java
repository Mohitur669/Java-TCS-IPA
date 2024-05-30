import java.util.HashSet;

public class FirstLongestNonRepeatedSubstring {
    public static void main(String[] args) {
        String s = "Arijit"; // Arij
        System.out.println(firstLongestNonRepeatedSubstring(s));
    }

    // TODO
    public static String firstLongestNonRepeatedSubstring(String s) {
        HashSet<Character> ch = new HashSet<>();
        String result =  "";

        for (int i = 0; i < s.length(); i++) {
            if (!ch.contains(s.charAt(i))) {
                ch.add(s.charAt(i));
                result += s.charAt(i);
            }
            else {
                break;
            }
        }

        return result;
    }
}