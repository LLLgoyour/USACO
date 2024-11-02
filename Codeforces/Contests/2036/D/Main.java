import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static final int N = 1010;
    static int[] a = new int[N * N];
    static char[][] s = new char[N][N];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                String line = br.readLine();
                for (int j = 1; j <= m; j++) {
                    s[i][j] = line.charAt(j - 1);
                }
            }

            int l = 1, r = m, u = 1, d = n, ans = 0;
            while (l < r && u < d) {
                int t = 0;
                for (int i = l; i < r; i++)
                    a[t++] = s[u][i] - '0';
                for (int i = u; i < d; i++)
                    a[t++] = s[i][r] - '0';
                for (int i = r; i > l; i--)
                    a[t++] = s[d][i] - '0';
                for (int i = d; i > u; i--)
                    a[t++] = s[i][l] - '0';
                for (int i = 0; i < t; i++) {
                    if (a[i] == 1 && a[(i + 1) % t] == 5 && a[(i + 2) % t] == 4 && a[(i + 3) % t] == 3)
                        ++ans;
                }
                ++l;
                --r;
                ++u;
                --d;
            }
            out.println(ans);
        }
        out.flush();
    }
}