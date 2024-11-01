import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            solve(br, pw);
        }
        pw.flush();
    }

    private static void solve(BufferedReader br, PrintWriter pw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a, 1, n + 1);
        int ans = 0;
        for (int l = 1, r = 2; r <= n; r++) {
            while (l < r && a[l] + a[l + 1] <= a[r]) {
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        pw.println(n - ans);
    }
}