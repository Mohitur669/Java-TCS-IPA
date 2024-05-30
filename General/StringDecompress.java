public class StringDecompress {
    public static void main(String[] args) {
        String s = "a2b5c1";
        System.out.println(stringDecompress(s));
    }

    public static String stringDecompress(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i += 2) {
//            int term = Integer.parseInt(String.valueOf(s.charAt(i+1)));
            int term = Character.getNumericValue(s.charAt(i + 1));
            for (int j = 0; j < term; j++) {
                ans = ans + s.charAt(i);
            }
        }

        return ans;
    }
}