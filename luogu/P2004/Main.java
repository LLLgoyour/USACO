import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // width
        int M = Integer.parseInt(s[1]); // length
        int C = Integer.parseInt(s[2]); // side length
        int[][] grid = new int[N][M];
        long[][] preSum = new long[N][M];
        int[] c = new int[2]; // coordinate
        long temp = 0;
        for (int i = 0; i < N; i++) {
            s = in.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(s[j]);
                if (i == 0) {
                    if (j == 0)
                        preSum[0][0] = grid[0][0];
                    else
                        preSum[0][j] = preSum[0][j - 1] + grid[0][j];
                } else {
                    if (j == 0)
                        preSum[i][0] = preSum[i - 1][0] + grid[i][0];
                    else
                        preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + grid[i][j];
                }
            }
        }
        for (int i = 0; i < N - C + 1; i++) {
            for (int j = 0; j < M - C + 1; j++) {
                long sum = preSum[i + C - 1][j + C - 1];
                if (i > 0)
                    sum -= preSum[i - 1][j + C - 1];
                if (j > 0)
                    sum -= preSum[i + C - 1][j - 1];
                if (i > 0 && j > 0)
                    sum += preSum[i - 1][j - 1];
                if (sum > temp) {
                    temp = sum;
                    c[0] = i + 1;
                    c[1] = j + 1;
                }
            }
        }
        in.close();
        System.out.println(c[0] + " " + c[1]);
    }
}