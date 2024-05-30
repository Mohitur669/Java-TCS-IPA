/*Count the number of words in a sentence that start and end with the same letter.

Input: Anna asked about the Ginseng recipe
Output: 2

Explanation: There are two words in the sentence that start and end with the same letter - "Anna" and "Ginseng". */

public class Count1stLastMatchingLetterWords {
    public static void main(String[] args) {
        String s = "Anna asked about the Ginseng recipe".toLowerCase();
        System.out.println(countMatching(s));
    }

    public static int countMatching(String s) {
        int count = 0;
        String[] arr = s.split(" ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) == arr[i].charAt(arr[i].length() - 1)) {
                count++;
            }
        }

        return count;
    }
}