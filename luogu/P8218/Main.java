import java.io.*;

public class Main {
    public static int[] prefixSum(int[] a) {
        int[] prefixSum = new int[a.length];
        prefixSum[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }
        return prefixSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int[] prefixSum = prefixSum(a);
        int m = Integer.parseInt(in.readLine());
        while (m-- > 0) {
            s = in.readLine().split(" ");
            int l = Integer.parseInt(s[0]);
            l -= 1;
            int r = Integer.parseInt(s[1]);
            r -= 1;
            if (l == 0) {
                System.out.println(prefixSum[r]);
            } else {
                System.out.println(prefixSum[r] - prefixSum[l - 1]);
            }
        }
        in.close();
    }
}
