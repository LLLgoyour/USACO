import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] p = new int[n];
        String[] s = in.readLine().split(" ");
        in.close();
        int max = 0, idx = 0, tmp = 0, tmpMax = 0;
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(s[i]);
            if (p[i] > max) {
                tmpMax = max;
                max = p[i];
                idx = i + 1; // not using ++i cuz will store i+=1.
            }
            if (p[i] > tmp) {
                if (p[i] == max) {
                    continue;
                }
                tmp = p[i];
            }
        }
        System.out.println(idx + " " + Math.max(tmpMax, tmp));
    }
}