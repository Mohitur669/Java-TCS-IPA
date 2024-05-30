/* Find the occurrence of each character in a string
 * Input: Hello world
 * Output:
 *  H: 1
    e: 1
    l: 3
    o: 2
    w: 1
    r: 1
    d: 1
*/

import java.util.HashMap;
import java.util.LinkedHashMap;

// TODO
public class FrequencyOfCharacterInString {
    public static void main(String[] args) {
        String str = "Hello World";
        String s = str.replace(" ", "");
        LinkedHashMap<Character, Integer> count = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!count.containsKey(s.charAt(i))) {
                count.put(s.charAt(i), 1);
            } else {
                count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
            }
        }
        for (HashMap.Entry<Character, Integer> data : count.entrySet()) {
            System.out.println(data.getKey() + ": " + data.getValue());
        }
    }
}