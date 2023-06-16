import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int maxSubArray(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static int maxWeightedRectangleSum(int[][] matrix) {
        int n = matrix.length;
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < n; left++) {
            int[] rowSum = new int[n];

            for (int right = left; right < n; right++) {
                for (int i = 0; i < n; i++) {
                    rowSum[i] += matrix[i][right];
                }

                int currentSum = maxSubArray(rowSum);
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = in.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        in.close();

        int maxSum = maxWeightedRectangleSum(matrix);
        System.out.println(maxSum);
    }
}