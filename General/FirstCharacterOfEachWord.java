public class FirstCharacterOfEachWord {
    public static void main(String[] args) {
        String s = "My name is Mohd Mohitur Rahaman";

        String result = "";
        result += s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                result += s.charAt(i + 1);
            }
        }

        System.out.println(result);
    }
}