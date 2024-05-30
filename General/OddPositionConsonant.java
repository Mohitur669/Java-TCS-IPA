public class OddPositionConsonant {
    public static void main(String[] args) {
        String s = "Arijit Ghosh";
        System.out.println(oddPositionConsonant(s.toLowerCase()));
    }

    public static String oddPositionConsonant(String s) {
        String t = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && i % 2 == 0) {
                t += c;
            }
        }

        return t;
    }
}