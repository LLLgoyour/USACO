import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            solve(br, pw);
        }
        pw.flush();
    }

    private static void solve(BufferedReader br, PrintWriter pw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n * 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n * 2; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = Arrays.stream(a).sum();
        int m_i = cnt & 1;
        int m_x = Math.min(cnt, 2 * n - cnt);
        pw.println(m_i + " " + m_x);
    }
}