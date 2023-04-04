package P4431;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Kosnja {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            System.out.println(2 * (Math.min(n, m) - 1));
        }
    }
}