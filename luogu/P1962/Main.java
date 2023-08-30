import java.io.*;

public class Main { static int mod=1000000007;
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
        int fib = 0;
        for (int i = 2; i < n; i++){
            matrixExponentiation(i);
        }
        System.out.println(fib);

    }
}
