import java.util.Scanner;

public class AdditionWithLimit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        int limit1 = sc.nextInt();
        int limit2 = sc.nextInt();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i] > limit1 && arr[i] < limit2) {
                sum += arr[i];
                count++;
            }
            if (i == limit2) break;
        }
        System.out.println(sum / count);
    }
}