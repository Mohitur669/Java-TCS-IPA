public class PalindromeString {
    public static void main(String[] args) {
        String str = "abbe";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
        String reverseString = reverse(str);
        if (str.equals(reverseString)) {
            return true;
        }
        return false;
    }

    static String reverse(String str) {
        String reverseString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseString = reverseString + str.charAt(i);
        }
        return reverseString;
    }
}