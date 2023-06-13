import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] a = new int[n];
        String[] s = in.readLine().split(" ");
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        int ans = 0;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            Arrays.sort(a);
            if (i == 1) {
                sum = a[i] + a[i - 1];
                ans += sum;
                continue;
            }
            sum += a[i];
            ans += sum;
        }
        System.out.println(ans);
        in.close();
    }
}
