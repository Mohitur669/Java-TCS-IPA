public class SumOfPrimeDigit {
    public static void main(String[] args) {
        String s = "2345678910"; //17
        System.out.println(countPrimeDigit(s));
    }

    public static int countPrimeDigit(String str) {
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (digit == 2 || digit == 3 || digit == 5 || digit == 7) {
                sum += digit;
            }
        }

        return sum;
    }
}