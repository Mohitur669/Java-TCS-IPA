/* Input : 123Arijit1998Arijit10

 * Process :
 * -----------
 * Array : [123, Arijit, 1998, Arijit, 10]
 * Now you should sum up the position of that array where numbers are stored.
 * 123 + 1998 = 2121
 *
 * Output :
 * --------------
 * 2131
 */

public class SumOfNumbersInString {
    public static void main(String[] args) {
        String str = "123Arijit1998Arijit10";
        System.out.println(sumOfNumbersInString(str));
    }

    public static int sumOfNumbersInString(String str) {
        int sum = 0;
        int num = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                num = (num *10) + Integer.parseInt(String.valueOf(ch));
            }

            else if (!Character.isDigit(ch)){
                sum += num;
                num = 0;
            }
        }

        // TODO
        if (num > 0) {
            sum += num;
        }

        return sum;
    }
}