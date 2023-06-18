import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int p = Integer.parseInt(s[1]);
        s = in.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int[] diff = new int[n + 1];
        while (p-- > 0) {
            s = in.readLine().split(" ");
            int l = Integer.parseInt(s[0]);
            int r = Integer.parseInt(s[1]);
            int score = Integer.parseInt(s[2]);
            diff[l - 1] += score;
            diff[r] -= score;
            for (int i = 0; i < n; i++) {
            }
        }
        int[] preSum = new int[n];
        preSum[0] = diff[0] + a[0];
        int min = preSum[0];
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
            preSum[i] = diff[i] + a[i];
            if (preSum[i] < min) {
                min = preSum[i];
            }
        }
        in.close();
        System.out.println(min);
    }
}
