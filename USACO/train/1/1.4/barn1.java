/*
ID: lllgoyo2
LANG: JAVA
TASK: barn1
 */

import java.io.*;
import java.util.*;

class Gap implements Comparable<Gap> {
    int start, end;

    Gap(int s, int e) {
        start = s;
        end = e;
    }

    public int compareTo(Gap o) {
        return getSize() - o.getSize();
    }

    public int getSize() {
        return end - start - 1;
    }
}

public class barn1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        Gap g;

        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int boards, stallsCovered = c;

        int[] stalls = new int[c];
        ArrayList<Gap> gaps = new ArrayList<>();

        for (int i = 0; i < c; i++) {
            stalls[i] = Integer.parseInt(f.readLine());
        }

        Arrays.sort(stalls);

        for (int i = 1; i < c; i++) {
            if (stalls[i] - stalls[i - 1] > 1) {
                gaps.add(new Gap(stalls[i - 1], stalls[i]));
            }
        }

        Collections.sort(gaps);

        boards = gaps.size() + 1;

        while (boards > m) {
            g = gaps.remove(0);
            stallsCovered += g.getSize();
            boards--;
        }

        out.println(stallsCovered);
        out.close();
    }
}