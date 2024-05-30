import java.util.Locale;

public class CountWordStartWithVowel {
    public static void main(String[] args) {
        String s = "Mohitur is student of MCA";
        System.out.println(vowelStart(s));
    }

    public static int vowelStart(String s) {
        s = s.toLowerCase();
        String[] arr = s.split(" ");

        int count = 0;
        for (String str : arr) {
            char c = str.charAt(0);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }

        return count;
    }
}