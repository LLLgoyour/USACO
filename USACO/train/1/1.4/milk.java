/*
ID: lllgoyo2
LANG: JAVA
TASK: milk
 */

import java.io.*;
import java.util.*;

public class milk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = 0;
        int expected = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] quan = new int[1001];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            quan[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 1001 && expected > 0; i++) {
            if (expected >= quan[i]) {
                min += i * quan[i];
                expected -= quan[i];
            } else {
                min += i * expected;
                expected = 0;
            }
        }

        pw.println(min);
        pw.close();
    }
}
