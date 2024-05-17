public class CharCount {
    public static void main(String[] args) {
        String s = "Mohd Mohitur Rahaman";
        String t = "o";
        System.out.println(charCount(s, t));
    }

    public static int charCount(String s, String t) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(0)) {
                count++;
            }
        }

        return count;
    }
}