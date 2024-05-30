public class FindWordWithUpperCase {
    public static void main(String[] args) {
        String s = "The quick Brown Fox jumps over the lazy dog";

        String[] arr = s.split(" ");

        for (String string : arr) {
            if (string.charAt(0) >= 'A' && string.charAt(0) <= 'Z') {
                System.out.println(string);
            }
        }
    }
}