import java.io.*;
import java.util.*;

class IsCat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            s.toLowerCase();
            char[] c = s.toCharArray();
            int meow = 0;
            for (int i = c.length; i > 0; i--) {
                if (c[i] == 'e') {
                    if (c[i - 1] == 'm') {
                        meow++;
                        continue;
                    } else if (c[i - 1] == 'e') {
                        continue;
                    }
                }
                if (c[i] == 'o') {
                    if (c[i - 1] == 'e') {
                        meow++;
                        continue;
                    } else if (c[i - 1] == 'o') {
                        continue;
                    }
                }
                if (c[i] == 'w') {
                    if (c[i - 1] == 'o') {
                        meow++;
                        continue;
                    } else if (c[i - 1] == 'w') {
                        continue;
                    }
                }
            }
            if (meow == 3) {
                pw.println("YES");
            } else
                pw.println("NO");
        }
        pw.close();
    }
}