import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static final int N = (int) 1.01e6;
    static int T, n, c, q;
    static char[] s = new char[N];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            s = br.readLine().toCharArray();
            n = s.length;
            c = 0;
            for (int i = 0; i < n; i++)
                ck(i, 1);
            q = Integer.parseInt(br.readLine());
            while (q-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ck(x - 4, -1);
                ck(x - 3, -1);
                ck(x - 2, -1);
                ck(x - 1, -1);
                s[x - 1] = (char) ('0' + y);
                ck(x - 4, 1);
                ck(x - 3, 1);
                ck(x - 2, 1);
                ck(x - 1, 1);
                if (c > 0)
                    out.println("YES");
                else
                    out.println("NO");
            }
        }
        out.flush();
    }

    static void ck(int x, int t) {
        if (x < 0 || x + 3 >= n)
            return;
        if (s[x] == '1' && s[x + 1] == '1' && s[x + 2] == '0' && s[x + 3] == '0')
            c += t;
    }
}