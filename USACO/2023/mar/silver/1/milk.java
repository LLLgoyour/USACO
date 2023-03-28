import java.util.*;
import java.io.*;

class milk {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        long[] amt = new long[n];
        for (int i = 0; i < n; i++) {
            amt[i] = sc.nextLong();
        }
        long[] sIdx = oldLoc(amt);
        int q = sc.nextInt();
        long[][] queries = new long[q][2];
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextLong() - 1;
            queries[i][1] = sc.nextLong();
        }
        Arrays.sort(amt);
        long t = 0;
        for (int i = 0; i < n; i++) {
            t += (i + 1) * amt[i];
        }
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + amt[i];
        }
        for (int i = 0; i < q; i++) {
            long sQIdx = sIdx[(int) queries[i][0]];
            System.out.println(res(amt, sQIdx, queries[i][1], t, prefixSum));
        }
    }

    static long[] oldLoc(long[] nums) {
        int n = nums.length;
        long[][] ans = new long[n][2];
        for (int i = 0; i < n; i++) {
            ans[i][0] = nums[i];
            ans[i][1] = i;
        }
        Arrays.sort(ans, (a, b) -> Long.compare(a[0], b[0]));
        long[] f = new long[n];
        for (int i = 0; i < n; i++) {
            f[(int) ans[i][1]] = i;
        }
        return f;
    }

    static long searchInsert(long[] nums, long target, long idx) {
        long l = 0;
        long r = nums.length - 1;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (nums[(int) m] == target) {
                if (target >= nums[(int) idx])
                    return m;
                else
                    return m + 1;
            }
            if (nums[(int) m] <= target) {
                l = m + 1;
            } else
                r = m - 1;
        }
        if (target >= nums[(int) idx])
            return l - 1;
        return l;
    }

    static long res(long[] amt, long qIdx, long qValue, long t, long[] prefixSum) {
        long newLoc = searchInsert(amt, qValue, qIdx);
        long oldValue = (qIdx + 1) * amt[(int) qIdx];
        long newValue = qValue * (newLoc + 1);

        long ct = t - oldValue + newValue;
        if (newLoc < qIdx) {

            ct += prefixSum[(int) qIdx] - prefixSum[(int) newLoc];
        } else if (newLoc > qIdx) {
            ct -= prefixSum[(int) newLoc + 1] - prefixSum[(int) qIdx + 1];
        }

        return ct;
    }
}