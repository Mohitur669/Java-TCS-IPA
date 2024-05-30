public class LargestWordInString {
    public static void main(String[] args) {
        String s = "My name is Mohd Mohitur Rahaman.";
        String[] arr = s.split(" ");

        String max = "";
        for (String string : arr) {
            if (string.length() > max.length()) {
                max = string;
            }
        }

        System.out.println(max);
    }
}