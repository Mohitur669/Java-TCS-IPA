/*Count the number of words in a sentence that contain at least two consecutive vowels (a, e, i, o, u) in them.
Here's a sample input and output:

Input: I enjoy eating spaghetti and meatballs for dinner
Output: 2

Explanation: There are two words in the sentence that contain at least two consecutive vowels - "eating" and "meatballs".
 */

// TODO
import java.util.Scanner;

public class ConsecutiveVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();
        int count = countWordsWithConsecutiveVowels(sentence);
        System.out.println("Output: " + count);
    }

    public static int countWordsWithConsecutiveVowels(String sentence) {
        String[] words = sentence.split(" ");
        int count = 0;

        for (String word : words) {
            if (hasConsecutiveVowels(word)) {
                count++;
            }
        }

        return count;
    }

    public static boolean hasConsecutiveVowels(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            char current = word.charAt(i);
            char next = word.charAt(i + 1);
            if (isVowel(current) && isVowel(next)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}