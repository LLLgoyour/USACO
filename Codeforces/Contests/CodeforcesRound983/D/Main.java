import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br;
    private static PrintWriter pw;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            solve();
        }
        pw.flush();
    }

    private static boolean query(int x, int y) throws IOException {
        pw.printf("? %d %d\n", x, y);
        pw.flush();
        st = new StringTokenizer(br.readLine());
        int res = Integer.parseInt(st.nextToken());
        return res == 1;
    }

    private static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n + 1];
        int[] p = new int[n + 1];
        int[] stk = new int[n + 1];
        int l = 1, r = 0;

        int se = 0;
        for (int i = 2; i < n; i++) {
            if (!query(1, i)) {
                se = i;
                p[se] = 1;
                break;
            }
        }
        for (int i = 2; i < se; i++) {
            stk[++r] = i;
            p[i] = 0;
        }
        stk[++r] = se;
        for (int i = se + 1; i < n; i++) {
            while (stk[l] < p[i - 1]) {
                ++l;
            }
            while (l < r && query(stk[l], i)) {
                ++l;
            }
            p[i] = stk[l];
            ++l;
            stk[++r] = i;
        }
        pw.print("! ");
        for (int i = 1; i < n; i++) {
            pw.print(p[i] + " ");
        }
        pw.println();
        pw.flush();
    }
}