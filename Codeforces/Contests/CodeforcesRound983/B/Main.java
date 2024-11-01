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
        int k = Integer.parseInt(st.nextToken());

        if ((n + 1) / 2 == k) {
            pw.println(1);
            pw.println(1);
            return;
        }
        if (k == 1 || k == n) {
            pw.println(-1);
            return;
        }
        if ((k - 1) % 2 == 0) {
            pw.println(5);
            pw.println("1 2 " + k + " " + (k + 1) + " " + (k + 2));
            return;
        }
        pw.println(3);
        pw.println("1 " + k + " " + (k + 1));
    }
}