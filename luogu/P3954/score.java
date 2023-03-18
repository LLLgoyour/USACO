package P3954;

import java.io.*;
import java.util.*;

public class score {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());
        int ans = (int) (a * 0.2 + b * 0.3 + c * 0.5);
        pw.println(ans);
        pw.close();
    }
}
