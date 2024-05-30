/* Input: "Hello@123World456"

Process:
Array: ["Hello", "@", "123", "World", "456"]
Now you should concatenate all the strings in the array and multiply it with the sum of the position of that array where
numbers are stored.
Sum of positions of numbers in the array = 3 + 5 = 8
Concatenated string = "Hello@123World456"
Result = 8 * "Hello@123World456" = "Hello@123World456Hello@123World456Hello@123World456Hello@123World456Hello@123World456
Hello@123World456Hello@123World456Hello@123World456"

Output:
"Hello@123World456Hello@123World456Hello@123World456Hello@123World456Hello@123World456
Hello@123World456Hello@123World456Hello@123World456"
*/

import java.util.*;

// TODO
public class StringProcessor {
    public static void main(String[] args) {
        String input = "Hello@123World456";
        String[] parts = splitString(input);

        int sumOfNumericPositions = 0;
        StringBuilder concatenatedString = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            concatenatedString.append(parts[i]);
            if (isNumeric(parts[i])) {
                sumOfNumericPositions += (i + 1);
            }
        }

        String result = repeatString(concatenatedString.toString(), sumOfNumericPositions);
        System.out.println(result);
    }

    public static String[] splitString(String input) {
        List<String> parts = new ArrayList<>();
        StringBuilder currentPart = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (currentPart.isEmpty()) {
                currentPart.append(c);
            } else {
                char lastChar = currentPart.charAt(currentPart.length() - 1);
                if (Character.isDigit(lastChar) && Character.isDigit(c)) {
                    currentPart.append(c);
                } else if (Character.isLetter(lastChar) && Character.isLetter(c)) {
                    currentPart.append(c);
                } else if (!Character.isLetterOrDigit(lastChar) && !Character.isLetterOrDigit(c)) {
                    currentPart.append(c);
                } else {
                    parts.add(currentPart.toString());
                    currentPart = new StringBuilder();
                    currentPart.append(c);
                }
            }
        }
        parts.add(currentPart.toString());

        return parts.toArray(new String[0]);
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static String repeatString(String str, int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(str);
        }
        return result.toString();
    }
}