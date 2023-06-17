import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long mod;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        mod = Long.parseLong(st.nextToken());

        long[][] matrix = new long[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Long.parseLong(st.nextToken()) % mod;
            }
        }

        long det = determinant(matrix, n);
        if (det < 0) {
            det += mod;
        }

        System.out.println(det);
    }

    // Function to calculate the determinant of the matrix
    static long determinant(long[][] matrix, int n) {
        long det = 1;
        int sign = 1;

        for (int i = 0; i < n; i++) {
            int pivot = -1;

            // Finding the pivot element
            for (int j = i; j < n; j++) {
                if (matrix[j][i] != 0) {
                    pivot = j;
                    break;
                }
            }

            // If pivot is not found, determinant is 0
            if (pivot == -1) {
                return 0;
            }

            // Swapping rows if necessary
            if (pivot != i) {
                swapRows(matrix, pivot, i);
                sign *= -1;
            }

            long pivotElement = matrix[i][i];
            det = (det * pivotElement) % mod;
            long pivotInverse = modInverse(pivotElement, mod);

            // Performing row operations to reduce the matrix to row-echelon form
            for (int j = i + 1; j < n; j++) {
                long factor = (matrix[j][i] * pivotInverse) % mod;

                for (int k = i; k < n; k++) {
                    matrix[j][k] = (matrix[j][k] - (matrix[i][k] * factor) % mod + mod) % mod;
                }
            }
        }

        return (det * sign + mod) % mod;
    }

    // Function to swap two rows of the matrix
    static void swapRows(long[][] matrix, int row1, int row2) {
        long[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    // Function to calculate the modular inverse of a number
    static long modInverse(long a, long mod) {
        long b = mod;
        long x = 0, y = 1;
        long lastX = 1, lastY = 0;

        while (b != 0) {
            long quotient = a / b;

            long temp = a;
            a = b;
            b = temp % b;

            temp = x;
            x = lastX - quotient * x;
            lastX = temp;

            temp = y;
            y = lastY - quotient * y;
            lastY = temp;
        }

        return lastX < 0 ? lastX + mod : lastX;
    }
}