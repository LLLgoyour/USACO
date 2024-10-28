import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int N = (int) 1.01e6;
    static long[] a = new long[N], s = new long[N], f = new long[N], sf = new long[N], ss = new long[N];
    static int n;

    public static long calc(long x) {
        int L = 0, R = n, t = 0;

        while (L <= R) {
            int M = (L + R) / 2;
            if ((n + n - M + 1L) * M / 2 <= x) {
                t = M;
                L = M + 1;
            } else {
                R = M - 1;
            }
        }

        long res = sf[t];
        int l = t + 1, r = (int) (t + (x - (n + n - t + 1L) * t / 2));

        if (1 <= l && l <= n && l <= r && r <= n) {
            res += (ss[r] - ss[l - 1]) - (s[r] - s[l - 1]) * (n - l + 1 - (r - l + 1));
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(st.nextToken());
            s[i] = s[i - 1] + a[i];
            f[1] += a[i] * (n - i + 1);
            ss[i] = ss[i - 1] + a[i] * (n - i + 1);
        }

        sf[1] = f[1];

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] - a[i - 1] * (n - i + 2);
            sf[i] = sf[i - 1] + f[i];
        }

        int q = Integer.parseInt(br.readLine().trim());

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            System.out.println(calc(r) - calc(l - 1));
        }
    }
}