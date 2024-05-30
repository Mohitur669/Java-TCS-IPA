import java.util.Scanner;

public class PerfectSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double ans = Math.sqrt(n);
        if ((int) ans == ans) {
            System.out.println("Perfect Square");
        }
    }
}