package P2029;

import java.io.*;
import java.util.*;

public class thirsty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        double h = Double.parseDouble(st.nextToken());
        double r = Double.parseDouble(st.nextToken());
        r = r * r * 3.14;
        h *= r;
        int ans = 20000 % h == 0 ? (int) Math.floor(20000 / h) : (int) Math.ceil(20000 / h);
        pw.println(ans);
        pw.close();
    }
}
