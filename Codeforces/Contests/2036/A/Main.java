import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static final int N = 50 + 10;
    static int n;
    static int[] a = new int[N];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            boolean valid = true;
            for (int i = 2; i <= n; i++) {
                if (Math.abs(a[i] - a[i - 1]) != 5 && Math.abs(a[i] - a[i - 1]) != 7) {
                    out.println("NO");
                    valid = false;
                    break;
                }
            }
            if (valid) {
                out.println("YES");
            }
        }

        out.flush();
    }
}