package P1425;

import java.io.*;
import java.util.*;

public class swim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int hr = c - a;
        int min = d - b;
        if (min < 0) {
            min += 60;
            hr--;
        }
        pw.println(hr + " " + min);
        pw.close();
    }
}
