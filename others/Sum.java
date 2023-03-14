// https://web.archive.org/web/20230129165326/https://judge.yosupo.jp/problem/static_range_sum

import java.io.*;
import java.util.*;

class Sum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int a[] = new int[n];
        int range[] = new int[2];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line[i]);
            pw.println(a[i]);
        }
        for (int i = 0; i < q; i++) {
            int sum = 0;
            line = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                range[j] = Integer.parseInt(line[j]);
            }
            for (int j = range[0]; j < range[1]; j++) {
                sum += a[j];
            }
            pw.println(sum);
        }
        pw.close();
    }
}