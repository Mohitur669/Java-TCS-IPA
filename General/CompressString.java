public class CompressString {
    public static void main(String[] args) {
        String s = "aabbbcc";
        System.out.println(charRepeat(s));
    }

    public static String charRepeat(String s) {
        String t = "";
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                t += s.charAt(i - 1) + "" + count;
                count = 1;
            }
        }

        t += s.charAt(s.length() - 1) + "" + count;
        return t;
    }
}