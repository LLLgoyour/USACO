import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve(br);
        }
    }

    static void solve(BufferedReader br) throws IOException {
        long n = Long.parseLong(br.readLine());
        String s = br.readLine();
        long[] free = new long[(int) n];
        long p = n - 1;

        for (long i = n - 2; i >= 0; i--) {
            if (s.charAt((int) i) == '1')
                continue;
            while (p > i && s.charAt((int) p) == '0')
                p--;
            if (p > i) {
                free[(int) p] = 1;
                p--;
            }
        }

        long cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (free[i] == 1 || s.charAt(i) == '0')
                continue;
            cnt1++;
        }

        for (int i = (int) n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1' && cnt1 >= 2 && free[i] == 0) {
                free[i] = 1;
                cnt1 -= 2;
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (free[i] == 0) {
                ans += (i + 1);
            }
        }

        System.out.println(ans);
    }
}