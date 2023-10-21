import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        br.close();

        int MOD = 1000000007; // 10^9 + 7

        long[] ways = new long[n + 1];
        ways[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6 && i - j >= 0; j++) {
                ways[i] = (ways[i] + ways[i - j]) % MOD;
            }
        }

        System.out.println(ways[n]);
    }
}
