/* Calculate the sum of all digits of a numbers. If the sum is greater than 9 then again sum the digits. The sum is
continuing until the sum becomes one digit.

Input : 195
Output : 6

Explanation: 1+9+5 =15>9, so 1+5=6 */

public class SumUptoSingleDigit {
    public static void main(String[] args) {
        int n = 195;
        System.out.println(singleDigit(n));
    }

    public static int singleDigit(int n) {
        while (n > 9) {
            n = digitSum(n);
        }

        return n;
    }

    public static int digitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}