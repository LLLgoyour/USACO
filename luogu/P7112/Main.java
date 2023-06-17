import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int mod;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        mod = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % mod;
            }
        }

        int ans = determinant(matrix, n);
        if (ans < 0) {
            ans += mod;
        }

        System.out.println(ans);
    }

    // Function to calculate the determinant of the matrix
    static int determinant(int[][] matrix, int n) {
        int det = 1;

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
                det = (det * modInverse(-1)) % mod;
            }

            int pivotElement = matrix[i][i];
            det = (det * pivotElement) % mod;
            int pivotInverse = modInverse(pivotElement);

            // Performing row operations to reduce the matrix to row-echelon form
            for (int j = i + 1; j < n; j++) {
                int factor = (matrix[j][i] * pivotInverse) % mod;

                for (int k = i; k < n; k++) {
                    matrix[j][k] = (matrix[j][k] - factor * matrix[i][k] % mod + mod) % mod;
                }
            }
        }

        return det;
    }

    // Function to swap two rows of the matrix
    static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    // Function to calculate the modular inverse of a number
    static int modInverse(int a) {
        int b = mod;
        int x = 0, y = 1;
        int lastX = 1, lastY = 0;

        while (b != 0) {
            int quotient = a / b;
            int remainder = a % b;

            a = b;
            b = remainder;

            int temp = x;
            x = lastX - quotient * x;
            lastX = temp;

            temp = y;
            y = lastY - quotient * y;
            lastY = temp;
        }

        // Ensuring the modular inverse is positive
        if (lastX < 0) {
            lastX += mod;
        }

        return lastX;
    }
}

