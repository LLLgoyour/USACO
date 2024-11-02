import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static final int N = (int) 1.01e6;
    static int n, k, q, m;
    static int[][] a = new int[N][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            a[i] = new int[k + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= k; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (i > 1) {
                    a[i][j] |= a[i - 1][j];
                }
            }
        }

        while (q-- > 0) {
            m = Integer.parseInt(br.readLine());
            int l = 1, r = n;
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                char c = st.nextToken().charAt(0);
                int val = Integer.parseInt(st.nextToken());

                if (c == '>') {
                    int L = 1, R = n, p = n + 1;
                    while (L <= R) {
                        int M = (L + R) / 2;
                        if (a[M][id] > val) {
                            p = M;
                            R = M - 1;
                        } else {
                            L = M + 1;
                        }
                    }
                    l = Math.max(l, p);
                } else if (c == '<') {
                    int L = 1, R = n, p = 0;
                    while (L <= R) {
                        int M = (L + R) / 2;
                        if (a[M][id] < val) {
                            p = M;
                            L = M + 1;
                        } else {
                            R = M - 1;
                        }
                    }
                    r = Math.min(r, p);
                }
            }
            if (l <= r) {
                out.println(l);
            } else {
                out.println("-1");
            }
        }
        out.flush();
    }
}