public class MaxPrimeDiagonal {
    // TODO
    public static void main(String[] args) {
        int[][] matrix = {
                {12, 4, 8},
                {5, 7, 6},
                {4, 8, 13}
        };

        int maxPrime = findMaxPrimeDiagonal(matrix);
        if (maxPrime != -1) {
            System.out.println("Maximum prime on the diagonals is: " + maxPrime);
        } else {
            System.out.println("No prime numbers found on the diagonals.");
        }
    }

    public static int findMaxPrimeDiagonal(int[][] matrix) {
        int n = matrix.length;
        int maxPrime = -1;

        for (int i = 0; i < n; i++) {
            // Check primary diagonal element
            if (isPrime(matrix[i][i])) {
                maxPrime = Math.max(maxPrime, matrix[i][i]);
            }

            // Check secondary diagonal element
            if (isPrime(matrix[i][n - i - 1])) {
                maxPrime = Math.max(maxPrime, matrix[i][n - i - 1]);
            }
        }

        return maxPrime;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}