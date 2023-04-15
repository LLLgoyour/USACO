package P2879;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Cow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int hest = Integer.parseInt(input[2]);
        int r = Integer.parseInt(input[3]);
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = hest;
        }
        for (int i = 1; i <= r; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int first = Math.min(a, b);
            int second = Math.max(a, b);
            for (int j = first + 1; j < second; j++) {
                f[j]--;
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(f[i]);
        }
    }
}