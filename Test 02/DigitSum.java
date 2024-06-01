import java.util.Scanner;

public class DigitSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        if (sum % 3 == 0) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }
}