import java.io.*;
import java.util.*;

public class Main {
    static final int N = 200010;
    static final int V = 1000005;
    static long[] x = new long[N];
    static long[] sum = new long[V];
    static long[] sum2 = new long[V];
    static long[] cnt = new long[V];
    static Pair[] req = new Pair[V];
    static Query[] acq = new Query[N];
    static long[] ans = new long[N];

    static class Pair {
        long first, second;

        Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Query implements Comparable<Query> {
        long a, b, id;

        Query(long a, long b, long id) {
            this.a = a;
            this.b = b;
            this.id = id;
        }

        @Override
        public int compareTo(Query other) {
            long ta = this.a * other.b;
            long tb = this.b * other.a;
            return Long.compare(tb, ta);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            x[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            int tx = (int) (x[i] + 1);
            cnt[tx]++;
        }

        for (int i = 1; i <= V - 1; i++) {
            sum[i] = sum[i - 1];
            sum2[i] = sum2[i - 1];
            if (cnt[i] > 0) {
                sum2[i] += (long) i * cnt[i];
                sum[i] += cnt[i];
            }
        }

        for (int i = 1; i <= V - 1; i++) {
            long a = i * sum[i] - sum2[i];
            long b = (sum2[V - 1] - sum2[i]) - i * (n - sum[i]);
            req[i] = new Pair(a, b);
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= q; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            acq[i] = new Query(a, b, i);
        }

        Arrays.sort(acq, 1, q + 1);

        for (int i = 1, pot = 1; i <= q; i++) {
            while (pot < V - 1 && req[pot + 1].first * acq[i].a
                    + req[pot + 1].second * acq[i].b < req[pot].first * acq[i].a + req[pot].second * acq[i].b) {
                pot++;
            }
            int txun = (int) acq[i].id;
            ans[txun] = req[pot].first * acq[i].a + req[pot].second * acq[i].b;
        }

        for (int i = 1; i <= q; i++) {
            out.println(ans[i]);
        }

        out.close();
    }
}