public class CharacterPlace {
    public static void main(String[] args) {
        String s = "Mohitur";
        System.out.println(charEvenPlace(s));
        System.out.println(charOddPlace(s));
    }

    public static String charOddPlace(String s) {
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0) {
                t += s.charAt(i);
            }
        }

        return t;
    }

    public static String charEvenPlace(String s) {
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                t += s.charAt(i);
            }
        }

        return t;
    }
}