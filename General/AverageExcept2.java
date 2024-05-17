public class AverageExcept2 {
    public static void main(String[] args) {
        int limit = 5;
        int lower = 1;
        int upper = 4;
        System.out.println(avg(limit, lower, upper));
    }

    public static int avg(int n, int lower, int upper) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        arr[lower - 1] = 0;
        arr[upper - 1] = 0;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }

        return sum / n;
    }
}