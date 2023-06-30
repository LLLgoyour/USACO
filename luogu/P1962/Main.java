import java.io.*;

public class Main {
    // calculate
    public static double[][] matrixExponentiation(int power) {
        if (power == 1) {
            double[][] identityMatrix = { { 1, 0 }, { 0, 1 } };
            return identityMatrix;
        }

        double[][] result = { { 1, 0 }, { 0, 1 } };
        double[][] base = { { 1, 1 }, { 1, 0 } };

        while (power > 0) {
            if (power % 2 == 1) {
                result = matrixMultiply(result, base);
            }

            base = matrixMultiply(base, base);
            power /= 2;
        }

        return result;
    }

    // matrix multiplication
    public static double[][] matrixMultiply(double[][] matrix1, double[][] matrix2) {
        int n = matrix1.length;
        double[][] result = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double sum = 0.0;
                for (int k = 0; k < n; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    // print the matrix
    public static void printMatrix(double[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
        int f = 0;
        for (int i = 0; i < n; i++) {
            int minusone = 1;
            int minustwo = 1;
            if (i <= 2) {
                f = 1;
                continue;
            }
            f = minusone + minustwo;
            minustwo = minusone;
            minusone = f;
        }
        System.out.println(f);

    }
}
