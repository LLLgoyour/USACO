import java.io.*;

public class Main {
    public static int[][] prefixSums(int[][] in) {
        int[][] preSum = new int[in.length][in[0].length];
        preSum[0][0] = in[0][0];

        // prefix sum of first column and first row
        for (int i = 1; i < in.length; i++) {
            preSum[i][0] = preSum[i - 1][0] + in[i][0];
            preSum[0][i] = preSum[0][i - 1] + in[0][i];
        }

        // prefix sum in general
        for (int i = 1; i < in.length; i++) {
            for (int j = 1; j < in[0].length; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + in[i][j];
            }
        }

        return preSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = in.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        in.close();
        int[][] preSum = prefixSums(arr);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (preSum[i][j] > max) {
                    max = preSum[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
