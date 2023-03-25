package P4285;

import java.io.*;
import java.util.*;

public class Hanoii {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char[] str = new char[6];
        String[] line = br.readLine().split(" ");
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            str[i] = line[i].toCharArray()[0];
        }
        tryMove(n, str);
        pw.close();
    }

    static void tryMove(int n, char str[]) {
        int[] a, b, c;
        a = new int[n];
        b = new int[n];
        c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                
            }
            if (str[i] == 'AB') {
                b[i] = a[i];
            } else if (str[i] == 'B') {
                c[i] = a[i];
            }
        }
    }
}
