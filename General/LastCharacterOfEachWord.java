public class LastCharacterOfEachWord {
    public static void main(String[] args) {
        String s = "My name is Mohd Mohitur Rahaman.";

        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                ans += s.charAt(i - 1);
            }
        }

        ans += s.charAt(s.length() - 1);

        System.out.println(ans);
    }
}