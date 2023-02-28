import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class bakery {
    static int n, tc, tm;
    static long[][] orders;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            tc = sc.nextInt();
            tm = sc.nextInt();
            orders = new long[n][3];
            for (int i = 0; i < n; i++) {
                orders[i][0] = sc.nextLong(); // cookies
                orders[i][1] = sc.nextLong(); // muffins
                orders[i][2] = sc.nextLong(); // maximum waiting time
            }
            System.out.println(minMoonies());
        }
        sc.close();
    }

    static long minMoonies() {
        long lo = 0, hi = (long) 2e9;
        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;
            if (canServeAll(mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo * (long) Math.max(0, Math.min(tc - 1, tm - 1));
    }

    static boolean canServeAll(long moonies) {
        long totalTime = 0;
        for (int i = 0; i < n; i++) {
            long cookies = orders[i][0];
            long muffins = orders[i][1];
            long maxWaitTime = orders[i][2];
            if (cookies * (tc - moonies) + muffins * (tm - moonies) > maxWaitTime) {
                return false;
            }
            totalTime += cookies * tc + muffins * tm;
        }
        return totalTime <= (long) n * (long) tc * (long) tm - moonies * (long) n * (long) n;
    }
}
