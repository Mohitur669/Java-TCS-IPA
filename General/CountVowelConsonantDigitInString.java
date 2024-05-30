public class CountVowelConsonantDigitInString {
    public static void main(String[] args) {
        String s = "Modh 4M5ohitur4";

        int vowel = 0;
        int consonant = 0;
        int num = 0;

        // TODO
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                if (isVowel(c)) {
                    vowel++;
                } else {
                    consonant++;
                }
            } else if (Character.isDigit(c)) {
                num++;
            }
        }

        System.out.println("Vowel:" + vowel);
        System.out.println("Consonant:" + consonant);
        System.out.println("Digit:" + num);
    }

    private static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}