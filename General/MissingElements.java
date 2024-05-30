/*
 *Input : 1 2 4 8 9 11 12 14
 *Output : 3 5 6 7 10 13
 */

public class MissingElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9, 11, 12, 14};

        for (int i = 0; i < arr.length - 1; i++) {
            int num = arr[i];
            // TODO
            while (num + 1 != arr[i + 1]) {
                System.out.print(num + 1 + " ");
                num++;
            }
        }
    }
}