package luogu.P1725;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int[] f = new int[200010];
    static final int[] a = new int[200010];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n + 1; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        PriorityQueue<Integer> q1 = new PriorityQueue<>((A, B) -> (B - A));
        PriorityQueue<Integer> q2 = new PriorityQueue<>((A, B) -> (B - A));
        for (int i = 1; i <= l; i++) {
            q2.add(a[i]);
        }
        for (int i = l; i <= n; i++) {
            q1.add(f[i - l]);
            if (i - r - 1 >= l) {
                q2.add(f[i - r - 1]);
            }
            while (!q2.isEmpty() && q1.peek().equals(q2.peek())) {
                q1.poll();
                q2.poll();
            }
            f[i] = q1.peek() + a[i];
        }
        for (int i = n - r + 1; i <= n; i++) {
            ans = Math.max(ans, f[i]);
        }
        System.out.println(ans);
    }
}
