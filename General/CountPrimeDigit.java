public class CountPrimeDigit {
    public static void main(String[] args) {
        int n = 123455320;
        System.out.println(countPrimeDigit(n));
    }

    public static int countPrimeDigit(int n) {
        int count = 0;
        String s = "" + n;

        for (int i = 0; i < s.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (digit == 2 || digit == 3 || digit == 5 || digit == 7) {
                count++;
            }
        }

        return count;
    }
}