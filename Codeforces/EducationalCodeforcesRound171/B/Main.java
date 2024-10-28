import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            solve(br, out);
        }

        out.flush();
    }

    static void solve(BufferedReader br, PrintWriter out) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        if (n == 1) {
            out.println(1);
            return;
        }

        long ans = 0;

        if (n % 2 == 0) {
            for (int i = 1; i < n; i += 2) {
                ans = Math.max(ans, a[i] - a[i - 1]);
            }
        } else {
            ans = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                long t = 0;
                List<Long> b = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        b.add(a[j]);
                    }
                }

                for (int j = 1; j < b.size(); j += 2) {
                    t = Math.max(t, b.get(j) - b.get(j - 1));
                }

                ans = Math.min(ans, t);
            }
        }

        out.println(ans);
    }
}