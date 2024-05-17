public class Armstrong {
    public static void main(String[] args) {
        int n = 153;
        System.out.println(armstrong(n));
    }

    public static boolean armstrong(int n) {
        int ori = n;
        int sum = 0;

        while (n > 0) {
            int rem = n % 10;
            sum += rem * rem * rem;
            n = n / 10;
        }

        return ori == sum;
    }
}