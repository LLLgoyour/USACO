import java.util.*;

public class Main {
    static String[] a = new String[15];
    static String s;
    static boolean[] f = new boolean[15];
    static boolean ans;

    static void dfs(int dep, int x) {
        if (dep == s.length()) {
            ans |= (s.length() == x);
            return;
        }
        for (int i = 1; i <= 4; i++) {
            if (f[i])
                continue;
            if (a[i].indexOf(s.charAt(x)) != -1) {
                f[i] = true;
                dfs(dep + 1, x + 1);
                f[i] = false;
            }
            dfs(dep + 1, x);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        a[1] = in.next();
        a[2] = in.next();
        a[3] = in.next();
        a[4] = in.next();
        while (n-- != 0) {
            s = in.next();
            dfs(0, 0);
            System.out.println(ans ? "YES" : "NO");
            ans = false;
            Arrays.fill(f, false);
        }
    }
}