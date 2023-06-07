import java.io.*;

public class Main {
    public static int[] prefixSum(int[] a) {
        for (int i = 1; i < a.length; i++) {
            a[i] += a[i - 1];
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] input = in.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        int[] sum = prefixSum(a);
        int m = Integer.parseInt(in.readLine());
        int[] interval = new int[2];
        for (int i = 0; i < m; i++) {
            input = in.readLine().split(" ");
            interval[0] = Integer.parseInt(input[0]);
            interval[0]--;
            interval[1] = Integer.parseInt(input[1]);
            interval[1]--;
            System.out.println(sum[interval[1]] - (interval[0] > 0 ? sum[interval[0] - 1] : 0));
        }
        in.close();
    }
}
