import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateCharactersInString {
    public static void main(String[] args) {
        String input = "Mohitur Rahaman";
        String result = removeDuplicates(input);
        System.out.println(result);
    }

    public static String removeDuplicates(String input) {
        Set<Character> seen = new HashSet<>();
        String result = "";

        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                result += c;
            }
        }

        return result;
    }
}