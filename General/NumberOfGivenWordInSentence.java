public class NumberOfGivenWordInSentence {
    public static void main(String[] args) {
        String s = "My name is Mohd Mohitur Rahaman is";
        System.out.println(numberOfGivenWordInSentence(s, "is"));
    }

    public static int numberOfGivenWordInSentence(String s, String searchWord) {
        String[] arr = s.split(" ");
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(searchWord)) {
                count++;
            }
        }

        return count;
    }
}